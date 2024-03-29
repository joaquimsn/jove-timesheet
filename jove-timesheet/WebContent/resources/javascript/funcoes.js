/*Valida os campos que aceita apenas texto*/
function mascara(objeto, func){
	v_obj = objeto;
	v_func = func;
	setTimeout('exercutaMascara()', 1);
}

function exercutaMascara(){
	v_obj.value = v_func(v_obj.value);
}

function soNumeros(numero){
	return numero.replace(/\D/g,"");//Exclua tudo que nÃ£o for numeral e retorne o valor
}

function soTexto(texto){
	return texto.replace(/[^ÁáÃãÂâÉéÊêÍíÓóÕõÔôÚúÑñÇç\sa-zA-Z]/g,"").toUpperCase();//Exclua tudo que nÃ£o for letra e retorne o valor
}

function soTextoNumeros(textoNumero){
    return textoNumero.replace(/[^ÁáÃãÂâÉéÊêÍíÓóÕõÔôÚúÑñÇç\sa-zA-Z0-9]/g,"").toUpperCase();//Exclua tudo que nÃ£o for letra ou numero e retorne o valor
}

function mista(mista){
    return mista.replace(/[^ÁáÃãÂâÉéÊêÍíÓóÕõÔôÚúÑñÇç,.-\sa-zA-Z0-9\@\.\-\_]/g,"").toUpperCase();//Exclua tudo que nÃ£o for letra ou numero e retorne o valor
}


/*cpf*/
function validarCpf(Objcpf){
    var cpf = Objcpf;
    exp = /\.|\-/g;
    cpf = cpf.toString().replace( exp, "" ); 
    var digitoDigitado = eval(cpf.charAt(9)+cpf.charAt(10));
    var soma1=0, soma2=0;
    var vlr = 11;
    
    for(var n=0;n<9;n++){
            soma1+=eval(cpf.charAt(n)*(vlr-1));
            soma2+=eval(cpf.charAt(n)*vlr);
            vlr--;
    }       
    soma1 = (((soma1*10)%11)==10 ? 0:((soma1*10)%11));
    soma2=(((soma2+(2*soma1))*10)%11);
    
    var digitoGerado=(soma1*10)+soma2;
    if(digitoGerado!=digitoDigitado|| cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || 
    	cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || 
    	cpf == "77777777777"|| cpf == "88888888888" || cpf == "99999999999"){        
    	document.getElementById('lblErroCpf').innerHTML= '#CPF Invalido!';
    }else{
    	document.getElementById('lblErroCpf').innerHTML= '';
    }
}

function maskCpf(v){
		
	v=v.replace(/\D/g,"");                //Remove tudo o que não é dígito
	v=v.replace(/(\d{3})(\d)/,"$1.$2");    //Coloca ponto entre o terceiro e o quarto dígitos
	v=v.replace(/(\d{3})(\d)/,"$1.$2");    //Coloca ponto entre o setimo e o oitava dígitos
	v=v.replace(/(\d{3})(\d)/,"$1-$2");   //Coloca ponto entre o decimoprimeiro e o decimosegundo dígitos
	return v;
}

function maskCnpj(v){
    v=v.replace(/\D/g,"");                           //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/,"$1.$2");             //Coloca ponto entre o segundo e o terceiro dígitos
    v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3"); //Coloca ponto entre o quinto e o sexto dígitos
    v=v.replace(/\.(\d{3})(\d)/,".$1/$2");           //Coloca uma barra entre o oitavo e o nono dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2");              //Coloca um hífen depois do bloco de quatro dígitos
    return v;
}

function maskData(v){
		  document.getElementById('LblErroNascimento').innerHTML= '';
        v=v.replace(/\D/g,"");
        v=v.replace(/(\d{2})(\d)/,"$1/$2");
        v=v.replace(/(\d{2})(\d)/,"$1/$2");
        return v;
}

function validaData(element) {
	regex = /^((((0?[1-9]|1\d|2[0-8])\/(0?[1-9]|1[0-2]))|((29|30)\/(0?[13456789]|1[0-2]))|(31\/(0?[13578]|1[02])))\/((19|20)?\d\d))$|((29\/0?2\/)((19|20)?(0[48]|[2468][048]|[13579][26])|(20)?00))$/;
 
 	resultado = regex.test(element.value);
 	if(!resultado) {
   	document.getElementById('LblErroNascimento').innerHTML= '#Data Invalida!';
	}
}

function maskTelefone(v){
        v=v.replace(/\D/g,"");                            
        v=v.replace(/^(\d\d)(\d)/g,"($1) $2"); 
        v=v.replace(/(\d{4})(\d)/,"$1-$2");     
        return v;
}
 		
function maskCep(v){
        v=v.replace(/\D/g,"" );                           
        v=v.replace(/^(\d{5})(\d)/,"$1-$2"); 
        return v;
}


function validaEmail(email){
	  er = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;
	  
		if(er.exec(email)){
			document.getElementById('LblErroEmail').innerHTML= '';
		}
		else {
		  document.getElementById('LblErroEmail').innerHTML= '#e-mail invalido';
		}
}

function validaTextArea(textArea){
		var tamanho = 500;
		var resta = tamanho - textArea.value.length;
		document.getElementById('LblErroTextArea').innerHTML= '#Quantidade máxima permitida 500 caracteres resta = ' + resta;
}



//Tradução para as datas do primefaces
PrimeFaces.locales['pt_BR'] = {
	closeText: 'Fechar',
    prevText: 'Anterior',
    nextText: 'Próximo',
    currentText: 'Começo',
    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
    dayNamesMin: ['D','S','T','Q','Q','S','S'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Horas e Minutos',
    timeText: 'Tempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    currentText: 'Data Atual',
    ampm: false,
    month: 'Mês',
    week: 'Semana',
    day: 'Dia',
    allDayText : 'Todo Dia'
};
