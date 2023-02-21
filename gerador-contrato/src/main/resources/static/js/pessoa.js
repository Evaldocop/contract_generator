$(document).ready(function() {
	///https://igorescobar.github.io/jQuery-Mask-Plugin/docs.html
	$("#primeiraTestemunhacpf , #segundaTestemunhacpf").mask("999.999.999-99", {placeholder: "___.___.___-__"}, {reverse: true})
	/*$("#contratada-cnpj").on("keyup", function(e)
			{
			    $(this).val(
			        $(this).val()
			        .replace(/\D/g, '')
			        .replace(/^(\d{2})(\d{3})?(\d{3})?(\d{4})?(\d{2})?/, "$1.$2.$3/$4-$5"));
			});*/
});