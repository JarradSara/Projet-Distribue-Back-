package com.example.CulturalActivities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


	@RestController
	public class ActivityService {

		@Autowired
		ActivityRepository activityRepository; 

		public ActivityService(){
			
		}
		

		@CrossOrigin 
		@RequestMapping(value="/activites", method=RequestMethod.GET) 
		@ResponseStatus(HttpStatus.OK) 
		public Iterable<Activity> getListOfActivities(){
			return activityRepository.findAll();  
		} 

		@CrossOrigin
		@RequestMapping(value = "/activites", method = RequestMethod.POST	)
		@ResponseStatus(HttpStatus.OK)
		public void addActivity(@RequestBody Activity activity) throws Exception{

			Activity Activite = new Activity(activity.getIdActivite(), activity.getNomActivite(), activity.getDescriptionActivite(), activity.getNiveauActivite());
			activityRepository.save(Activite);
		}

		@CrossOrigin
		@RequestMapping(value = "/activites/{idActivite}", method = RequestMethod.GET) 
		@ResponseStatus(HttpStatus.OK)
		public Activity getActivity(@PathVariable(value = "idActivite") int idActivite){
			Activity activite = activityRepository.findByIdActivite(idActivite);
			return activite;

		}
		
		@CrossOrigin
		@RequestMapping(value = "/activites/{idActivite}", method = RequestMethod.PUT)
		@ResponseStatus(HttpStatus.OK)
		
	 	public void updateActivity(@RequestBody Activity activity) throws Exception{
			Activity Activite = new Activity(activity.getIdActivite(), activity.getNomActivite(), activity.getDescriptionActivite(), activity.getNiveauActivite());
			activityRepository.save(Activite);
		} 
		

		@CrossOrigin
		@RequestMapping(value = "/activites/{idActivite}", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.OK)
		public void getBack(@PathVariable(value="idActivite") int idActivite) throws Exception{
			System.out.println(idActivite);
			activityRepository.deleteById(idActivite); 
		} 
			
	
} 
			
			
			
	

