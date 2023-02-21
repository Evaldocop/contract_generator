$(document).ready(function() {
	///doc masc https://igorescobar.github.io/jQuery-Mask-Plugin/docs.html
	$("#contratada-endereco-cep, #contratante-endereco-cep").mask("99.999-999",{placeholder: "__.___-___"})
	
	/*	$("#contratada-endereco-cep").val("__.___-__");
	 * $("#contratada-endereco-cep").on("keyup", function(e)
			{
			    $(this).val(
			        $(this).val()
			        .replace(/\D/g, '')
			        .replace(/^(\d{2})(\d{3})?(\d{3})?/, "$1.$2-$3"));
	});*/
	
	
	$("#contratada-endereco-cep").on('change', function() {
		console.log("ENTREI");
		var cep = $(this).val();
		console.log(cep);
		$.ajax({
			
			method:"GET",
			url: "/contratos/endereco/" + cep,
			cache: false,
			success: function( data ){
				console.log(data.logradouro);
				$("#contratada-endereco-logradouro").val(data.logradouro);
				$("#contratada-endereco-cidade").val(data.localidade);
				$("#contratada-endereco-uf").val(data.uf);
			}
		});
		
	});
	
	$("#contratante-endereco-cep").on('change', function() {
		console.log("ENTREI");
		var cep = $(this).val();
		console.log(cep);
		$.ajax({
			
			method:"GET",
			url: "/contratos/endereco/" + cep,
			cache: false,
			success: function( data ){
				console.log(data.logradouro);
				$("#contratante-endereco-logradouro").val(data.logradouro);
				$("#contratante-endereco-cidade").val(data.localidade);
				$("#contratante-endereco-uf").val(data.uf);
			}
		});
		
	});
});