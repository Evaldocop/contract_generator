$(document).ready(function() {

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