package com.evaldo.geradorcontrato.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.evaldo.geradorcontrato.domain.Contrato;

@Component
public class TratamentoArquivo {
	private static final String PATH_FILE = "classpath:file/";
	private static final String NAME_FILE = "docword.docx";

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ParameterMap map;

	String chave = "";

	public String editarLinha(Map<String, String> parametros, String linha, boolean islinhanova) {
		int i = -1;
		int f = -1;

		if ((linha.contains("{") || linha.contains("}"))) {

			/* verica se tem */
			if (linha.contains("{")) {
				i = linha.indexOf('{');

				if (chave == "") {

					if (linha.substring(i, linha.length()).contains("}")) {
						f = linha.indexOf('}');
						// pego uma chave fecha if1
						if (f == (linha.length() - 1)) {
							chave = linha.substring(i, linha.length()).replace(" ", "");
							linha = linha.replace(chave, "");
							System.out.println("chave2 >>>" + chave);
							// return editarLinha(parametros, linha, false);
						} else {
							f = f + 2;
							linha = linha.replace(linha.substring(i, f), parametros.get(linha.substring(i, f)));
							// return editarLinha(parametros, linha, false);
						}

						// chave vazia linha inicio de chave sem } -- coloco
						// toda linha na chave
					} else {

						chave = linha.substring(i, linha.length()).replace(" ", "");
						linha = linha.replace(chave, "");

						System.out.println("chave3 >>>" + chave);
						// return editarLinha(parametros, linha, false);

					}
					// chave contem algo
				} else {
					if (linha.contains("}")) {
						f = linha.indexOf('}');
						i = 0;
						if (f == (linha.length() - 1))
							f = f + 1;// esta no fim da linha
						else
							f = f + 2; // esta no meio da linha
						chave = chave.concat(linha.substring(i, f)).replace(" ", "");
						System.out.println("chave3.1 >>>" + chave);
						if (chave.contains("{{") && chave.contains("}}")) {
							linha = linha.replace(linha.substring(i, f), parametros.get(chave));
							chave = "";
						} else {
							linha = linha.replace(linha.substring(i, f), "");
						}

					} else {
						f = linha.length();
						chave = chave.concat(linha.substring(i, f)).replace(" ", "");
						linha = linha.replace(linha.substring(i, f), "");
					}

				}

				// ou fim de chave com } ou }}
			} else if (linha.contains("}") && !chave.equals("")) {
				System.out.println("chave4 >>>" + chave);

				f = linha.indexOf('}');
				if (f == linha.length() - 1) {
					if (i < 0)
						i = 0;
					chave = chave.concat(linha.substring(i, linha.length())).replace(" ", "");

					System.out.println("chave5 >>>" + chave);

					if (chave.contains("{{") && chave.contains("}}")) {
						linha = linha.replace(linha.substring(i, linha.length()), parametros.get(chave));
						chave = "";
					} else
						linha = linha.replace(linha.substring(i, linha.length()), "");

				} else {
					f = f + 2;
					if (i == -1)
						i = 0;
					System.out.println("chave6 >>>" + chave);
					chave = chave.concat(linha.substring(i, f)).replace(" ", "").replace(" ", "");
					// System.out.println(">>>concat"+chave.trim() );
					System.out.println("chave7 >>>" + chave);
					linha = linha.replace(linha.substring(i, f), parametros.get(chave));
					chave = "";
					// return editarLinha(parametros, linha, false);
				}

			}
			return editarLinha(parametros, linha, false);
		} else {
			if (chave != "" && islinhanova) {
				if (chave.contains("{{") && chave.contains("}}")) {
					linha = linha.replace(chave, parametros.get(chave));
					chave = "";
				} else
					chave = chave.concat(linha).replace(" ", "");
				System.out.println("chave1 >>>" + chave);
				linha = "";
			}
			System.out.println(">>>saida processada -> " + linha);
			return linha;
		}
	}

	public void editarArquivo(Contrato contrato) {
		Map<String, String> parametros = map.carrregaParametros(contrato);

		try {
			FileInputStream fis = new FileInputStream(ResourceUtils.getFile(PATH_FILE + NAME_FILE));
			XWPFDocument doc = new XWPFDocument(fis);

			List<XWPFTable> tables = doc.getTables();

			for (XWPFTable table : tables) {
				List<XWPFTableRow> rows = table.getRows();
				for (XWPFTableRow row : rows) {
					List<XWPFTableCell> cells = row.getTableCells();
					for (XWPFTableCell cell : cells) {
						String newCellValue = "";
						if (cell.getText() != null && cell.getText().contains("}")) {
							newCellValue = editarLinha(parametros, cell.getText(), true);
							cell.removeParagraph(0);
							XWPFParagraph p = cell.addParagraph();
							p.createRun().setText(newCellValue);
						}
					}
				}

			}

			// Iterar sobre os parametros do documento

			for (XWPFParagraph p : doc.getParagraphs()) {

				for (XWPFRun r : p.getRuns()) { // Substituir o texto

					String linha = r.getText(0);
					if (linha != null) {
						System.out.println(">>>linha entrada >>> " + linha);
						linha = editarLinha(parametros, linha, true);
						r.setText(linha, 0);
					}

				}

			}

			String absolutePath = servletContext.getRealPath("outfile/template2.docx");
			FileOutputStream fos = new FileOutputStream(new File(absolutePath).getAbsolutePath());
			doc.write(fos);
			fos.close();
			fis.close();
			convertToPdff(absolutePath);
			System.out.println(">>>chave final " + chave);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void convertToPdff(String absolutePath) {
		OfficeManager officeManager = new DefaultOfficeManagerConfiguration()
				.setOfficeHome("C:\\Program Files (x86)\\OpenOffice.org 3").buildOfficeManager();
		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);

		try {
			officeManager.start();
			converter.convert(new File(absolutePath), new File(absolutePath.replace("docx", "pdf")));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			officeManager.stop();
		}
	}

	public void editarLinha() {
		try {
			FileInputStream fis = new FileInputStream(ResourceUtils.getFile(PATH_FILE + NAME_FILE));
			XWPFDocument doc = new XWPFDocument(fis);

			for (XWPFParagraph p : doc.getParagraphs()) {

				for (XWPFRun r : p.getRuns()) { // Substituir o texto

					String linha = r.getText(0);
					if (linha != null)
						System.out.println(linha + "---" + linha.length());

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
