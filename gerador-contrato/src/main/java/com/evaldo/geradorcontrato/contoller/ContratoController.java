package com.evaldo.geradorcontrato.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evaldo.geradorcontrato.domain.Contrato;
import com.evaldo.geradorcontrato.domain.Empresa;
import com.evaldo.geradorcontrato.domain.Pessoa;
import com.evaldo.geradorcontrato.service.ContratoService;
import com.evaldo.geradorcontrato.service.EmpresaService;
import com.evaldo.geradorcontrato.service.PessoaService;
import com.evaldo.geradorcontrato.util.TratamentoArquivo;




@Controller
@RequestMapping("/contratos")
public class ContratoController {
	@Autowired
	private ContratoService contratoService;

	@Autowired
	private EmpresaService serviceEmpresa;

	@Autowired
	private PessoaService pessoaService;
	
	

	@GetMapping("/cadastrar")
	public String cadastrar(Contrato contrato) {
		return "/novocontrato";
	}
	
	@GetMapping("/index")
	public String index() {
		 return "redirect:/";
	}

	@PostMapping
	public String submit(Contrato contrato, Model model) {
		model.addAttribute("contrato", contrato);

		Empresa contratada =serviceEmpresa.buscarPorCnpj(contrato.getContratada().getCnpj()).orElse(null);
		Empresa contratante=serviceEmpresa.buscarPorCnpj(contrato.getContratante().getCnpj()).orElse(null);
		
		Pessoa primeiraTestemunha =pessoaService.buscarPorCpf(contrato.getPrimeiraTestemunha().getCpf()).orElse(null);
		Pessoa segundaTestemunha =pessoaService.buscarPorCpf(contrato.getSegundaTestemunha().getCpf()).orElse(null) ;

		if (!serviceEmpresa.buscarPorCnpj(contrato.getContratada().getCnpj()).isPresent()) {
			serviceEmpresa.salvar(contrato.getContratada());
			contratada = serviceEmpresa.buscarPorCnpj(contrato.getContratada().getCnpj()).get();
			
		}

		if (!serviceEmpresa.buscarPorCnpj(contrato.getContratante().getCnpj()).isPresent()) {
			serviceEmpresa.salvar(contrato.getContratante());
			contratante = serviceEmpresa.buscarPorCnpj(contrato.getContratante().getCnpj()).get();
			
		}

		if (!pessoaService.buscarPorCpf(contrato.getPrimeiraTestemunha().getCpf()).isPresent()) {
			pessoaService.salvar(contrato.getPrimeiraTestemunha());
			primeiraTestemunha=pessoaService.buscarPorCpf(contrato.getPrimeiraTestemunha().getCpf()).get();
		    contrato.setPrimeiraTestemunha(primeiraTestemunha);
		}

		if (!pessoaService.buscarPorCpf(contrato.getSegundaTestemunha().getCpf()).isPresent()) {
			pessoaService.salvar(contrato.getSegundaTestemunha());
			segundaTestemunha=pessoaService.buscarPorCpf(contrato.getSegundaTestemunha().getCpf()).get();
		    
		}
		contrato.setContratante(contratante);
		contrato.setContratada(contratada);
		contrato.setPrimeiraTestemunha(primeiraTestemunha);
		contrato.setSegundaTestemunha(segundaTestemunha);
		
		contratoService.salvar(contrato);
        
		
		
		
		return "redirect:/";
	}

}
