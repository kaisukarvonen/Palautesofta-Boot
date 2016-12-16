package fi.haagahelia.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.haagahelia.models.Vastaus;
import fi.haagahelia.models.Kysymys;
import fi.haagahelia.repositories.KysymysRepository;
import fi.haagahelia.repositories.TyyppiRepository;
import fi.haagahelia.repositories.VastausRepository;

@Controller
@RequestMapping(value="*")
public class PalauteController {
	
	@RequestMapping("/")
	public String getindex() {
		return "index";
}
	
	@Autowired
	private KysymysRepository kysrepo;
	
	@Autowired
	private TyyppiRepository tyyppirepo;
	
	@Autowired
	private VastausRepository vastausrepo;
	
	
    @RequestMapping(value="kyselynsisalto.json", method=RequestMethod.GET )
    @ResponseBody
    public String listaaSisaltoJson() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	String prettyList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(kysrepo.findAll());
    	
    	return prettyList; 
    }

    
    @RequestMapping(value="kysymystyypit.json", method=RequestMethod.GET)
    @ResponseBody
    public String listaaKysymystyypitJson() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	String prettyList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tyyppirepo.findAll());
    	
    	return prettyList; 
    }
    
    
    @RequestMapping(value="lisaaMontaVastausta", method=RequestMethod.POST)
    @ResponseBody
    public List<Vastaus> lisaaMontaVastausta(@RequestBody List<Vastaus> lisatytVastaukset) {
    	vastausrepo.save(lisatytVastaukset);
    	
        return lisatytVastaukset;
    }
    
    
    @RequestMapping(value="lisaaKysymys", method=RequestMethod.GET)
    @ResponseBody
    public Kysymys lisaaKysymys(@RequestBody Kysymys k) {
    	return kysrepo.save(k);
    }
    
    
    @RequestMapping(value="/poista/{kysymys_id}", method=RequestMethod.GET)
    public String poistaKysymys(@PathVariable("kysymys_id") int kysId) {
    	kysrepo.removeById(kysId);
    	return "redirect:/index";
    }
    
    
    @RequestMapping(value="muokkaa/{kysymys_id}/{kysymys_arvo}", method=RequestMethod.GET)
    public String muokkaaKysymysta(@PathVariable("kysymys_id") int kysymysId, @PathVariable("kysymys_arvo") String kysymysArvo) {
    	kysrepo.updateKysymysNimi(kysymysId, kysymysArvo);
    	return "redirect:/index";
    }

}
