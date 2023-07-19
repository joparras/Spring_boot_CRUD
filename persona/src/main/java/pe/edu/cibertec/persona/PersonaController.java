package pe.edu.cibertec.persona;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("personas")
public class PersonaController {
    
    PersonaRepository personaRepository; 

   public PersonaController(PersonaRepository personaRepository ){
        this.personaRepository = personaRepository; 
    }
    
    @GetMapping
    public String list(Model modelo){
        List<Persona> personas = personaRepository.findAll();
        modelo.addAttribute("listaPersonas", personas);

        return "personas/list"; 
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        PersonaDto personaDto = new PersonaDto();
        model.addAttribute("personaForm", personaDto);
        return "personas/create";
    }

     @PostMapping
    public String create(PersonaDto personaDto) {
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(),personaDto.getDni(),personaDto.getEdad());
        personaRepository.save(persona);
        return "redirect:/personas";
    } 
}
