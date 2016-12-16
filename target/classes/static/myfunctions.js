$(document).ready(function() { 
	
	$("#paivita").click(function() {
		$.getJSON('/kyselynsisalto.json', function(sisalto) {
				for (var i=0; i < sisalto.length; i++) {
					var kysymysid = "kysymys"+sisalto[i].kysymys_id;
					var kysymysarvo = "kysymysarvo"+sisalto[i].kysymys_id;
					
					var vastausarvo = "vastaus"+sisalto[i].kysymys_id;

					if (sisalto[i].tyyppi_id == 1) {
						$(".kysymykset").append("<h4><div id="+kysymysid+"></div></h4><input type='text' id="+vastausarvo+"/><br/><br/>");
						$("#"+kysymysid).text(sisalto[i].kysymys_arvo);
					} else if (sisalto[i].tyyppi_id == 2) {
						$(".kysymykset").append("<h4><div id="+kysymysid+"></div></h4>" +
								"<input type='text' id="+vastausarvo+"/><br/><br/>");
					} else if (sisalto[i].tyyppi_id == 3) {
						
					}
					console.log(sisalto.length + ", kysymysid: "+kysymysid + ", kysymysarvo: "+kysymysarvo+", vastausarvo: "+vastausarvo);
				}
		});
	});
	
	
	
	$('#lisaaMontaVastausta').click(function() {
		var kysymys1Arvo = $('input[name="arvosana"]:checked').val();
		var kysymys2Arvo = $("#kysymys2_arvo").val();
        var kysymys1Vastaus = {vastaus_arvo: kysymys1Arvo, kysymys_id:6};
        var kysymys2Vastaus = {vastaus_arvo: kysymys2Arvo, kysymys_id:23};
        console.log(kysymys1Vastaus.vastaus_arvo + ", " + kysymys1Vastaus.kysymys_id);
        var vastaukset = [kysymys1Vastaus, kysymys2Vastaus];
        
        $.ajax({
            url: '/lisaaMontaVastausta',
            type: 'POST',
            data: JSON.stringify(vastaukset),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
            	$("#ajaxMessage").text("vastausten lisäys onnistui");
            },
            failure: function(errMsg) {
            	$("#ajaxMessage").text("vastausten lisäys epäonnistui");
            }
        });
	});
	
	
	$('#lisaaKysymys').click(function() {
		var kysymystyyppi = $('input[name="kysymystyyppi"]:checked').val();
		console.log(kysymystyyppi);
		var uusiKysymysArvo = $("#uusi_kysymys1").val();
		console.log("kysymys_arvo: "+uusiKysymysArvo);
		var tyyppi = 0;
		if (kysymystyyppi == 'avoin') {
			tyyppi = 1;
		} else if (kysymystyyppi == 'radiobutton') {
			tyyppi = 2;
		} else if (kysymystyyppi == 'skaala') {
			tyyppi = 3;
		}
		console.log(tyyppi);
        var uusiKysymys1 = {kysymys_arvo: uusiKysymysArvo, tyyppi_id:tyyppi};

        
        $.ajax({
            url: '${pageContext.request.contextPath}/lisaaKysymys',
            type: 'POST',
            data: JSON.stringify(uusiKysymys1),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
            	$("#ajaxMessage").text("kysymyksen lisäys onnistui");
            },
            failure: function(errMsg) {
            	$("#ajaxMessage").text("kysymyksen lisäys epäonnistui");
            }
        });
	});
		

	
});