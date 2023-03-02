$(document).ready(function() {
	///doc masc https://igorescobar.github.io/jQuery-Mask-Plugin/docs.html
	$("#contratada-cnpj , #contratante-cnpj").mask("99.999.999/9999-99", {placeholder: "__.___.___/____-__"})
	
	//$("#valPriFaixaLucro,#valSegFaixaLucro,#valTerFaixaLucro,#valFinal").mask('#.##0,00',{reverse: true});
	/*$("#contratada-cnpj").on("keyup", function(e)
			{
			    $(this).val(
			        $(this).val()
			        .replace(/\D/g, '')
			        .replace(/^(\d{2})(\d{3})?(\d{3})?(\d{4})?(\d{2})?/, "$1.$2.$3/$4-$5"));
			});*/
});