package com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.model.RobotInstance;
import com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.repository.RobotInstanceRepository;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@RestController
@RequestMapping("/rbinstance")
@CrossOrigin("${external-origin}")
public class RobotInstanceController {
	
	Logger log = Logger.getLogger(this.getClass()); 
	
	@Autowired
	private RobotInstanceRepository rbInstanceRepository;
	
	/**
	 * Retorna lista de cyberpunks
	 * @return List<CyberpunkHumanRobot>
	 */
	@GetMapping
	public List<RobotInstance> listAll(){
		List<RobotInstance> lista = rbInstanceRepository.findAllByOrderByIdAscActivDateAsc();
		return lista;
	}
		
	/**
	 * Busca um atributo
	 * @param id a ser buscado
	 * @return atributo encontrado
	 */
	@GetMapping(path="of/{id}")
	public List<RobotInstance> listInstanceOf(@PathVariable Long id){
		return rbInstanceRepository.findByRobotId(id);
	}
	
	/**
	 * Efetua o clone de um cyberpunk
	 * @param cyberpunkHR a ser clonado
	 * @return clone
	 * @throws CloneNotSupportedException Exception capturada ao tentar efetuar um clone
	 */
	@PostMapping("/clone")
	public RobotInstance clone(@RequestBody RobotInstance cyberpunkHR) throws CloneNotSupportedException{
		RobotInstance clone = null;		 
		/*if(validModel(cyberpunkHR)) {
			
			try {
				clone = cyberpunkHR.getNewClone(cyberpunkHR.getName(), cyberpunkHR.getAge(), 
						generateCloneVersion(cyberpunkHR.getOriginalId()) ,cyberpunkHR.getAdditional());
				List<RobotAttribute> additionalsList = clone.getAdditional();
				clone.setAdditional(new ArrayList<>());
				clone = add(clone);				
				//Preenche o id após inserção, e salva os atributos
				for(RobotAttribute attr: additionalsList) {
					attr.setRobotId(clone.getId());
				}
				clone.getAdditional().addAll(additionalsList);
				//Salva novamente com os adicionais
				clone = add(clone);
			} catch (CloneNotSupportedException e) {
				log.error("Error while trying to make a Cyberpunk clone: "+e.getMessage());
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Invalid clone data.");
		}*/
		return clone;
	}
	
	/**
	 * Efetua busca de cyberpunk
	 * @param cyberpunkHR a ser buscado
	 * @return cyberpunk encontrado
	 */
	@PostMapping("/search")
	public Optional<RobotInstance> search(@RequestBody RobotInstance cyberpunkHR){
		return rbInstanceRepository.findById(cyberpunkHR.getId());
	}
	
	/**
	 * Adiciona novo cyberpunk diferenciado
	 * @param cyberpunkHR novo cyberpunk
	 * @return objeto CyberpunkHumanRobot após persistencia
	 */	
	/*private RobotInstance add(RobotInstance cyberpunkHR){
		RobotInstance saved = rbInstanceRepository.save(cyberpunkHR);
		return saved;
	}*/
	
	/**
	 * Atualiza informações de um cyberpunk
	 * @param cyberpunkHR a ser atualizado
	 */
	@PostMapping("/update")
	public void update(@RequestBody RobotInstance cyberpunkHR){
		if(validModel(cyberpunkHR)) {
			
			try {
				rbInstanceRepository.save(cyberpunkHR);
			} catch (Exception e) {
				log.error("Error while trying to update a Cyberpunk clone: "+e.getMessage());
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Invalid clone data.");
		}
			
	}
	
	/**
	 * Deleta um cyberpunk do sistema
	 * @param cyberpunkHR a ser excluído
	 */
	@PostMapping("/delete")
	public void delete(@RequestBody RobotInstance cyberpunkHR){
		rbInstanceRepository.delete(cyberpunkHR);
	}
	
	/**
	 * Gera uma nova versão de para o clone
	 * @param parentId id do modelo principal
	 * @return versão definida para o novo modelo
	 */
	/*private Double generateCloneVersion(Long parentId){		
		CyberpunkHumanRobot parent = cyberpunkRepository.findById(parentId);
		CyberpunkHumanRobot lastClone = cyberpunkRepository.findTopByParentIdOrderByVersionDesc(parentId);
		
		StringBuilder newVersion = new StringBuilder(parent.getVersion());
		boolean hasMember = false;
		if(lastClone!=null) {
			hasMember = true;
			newVersion = new StringBuilder(lastClone.getVersion());
		}
		
		if(!hasMember){
			newVersion = newVersion.append(CyberpunkConstants.NEW_VERSION_STR);
		}
		else{
			String digit = newVersion.substring(newVersion.lastIndexOf(CyberpunkConstants.DOT_STR)+1,newVersion.length()).toString();
			newVersion = newVersion.delete(newVersion.lastIndexOf(CyberpunkConstants.DOT_STR)+1,newVersion.length());
			int newDigit = Integer.parseInt(digit) + 1;
			newVersion.append(newDigit);
		}
				
		return 1.0D;//newVersion.toString();		
	}*/
	
	/**
	 * Validate if model is able to clone
	 * @param instanceR the model to clone
	 * @return validation result
	 */
	private boolean validModel(RobotInstance instanceR){ //&& cyberpunkHR.getName().matches("[A-Z]{3}[0-9]{4}")
		if(instanceR.getName()==null ){
			return false;
		}else {
			List<RobotInstance> search = null;
			if(instanceR.getId()!=null) {
				search = rbInstanceRepository.findByNameAndIdNot(instanceR.getName(), instanceR.getId());
			}
			else {
				search = rbInstanceRepository.findByName(instanceR.getName());
			}
			if(search!=null && search.size()>0) {
				throw new IllegalArgumentException("This clone name is already in use, choose another better");
			}
		}
		return true;
	}	
}
