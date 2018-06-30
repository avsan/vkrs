package com.avsan.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/dailytrip"})
public class DailyTripController {
	/*@Autowired
	DailyTripDetailsService dailyTripDetailsService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyTripDetailsBean> getDailyTripDetailsBeanById(@PathVariable("id") int id) {
        System.out.println("Fetching DailyTripDetailsBean with id " + id);
        DailyTripDetailsBean DailyTripDetailsBean = dailyTripDetailsService.findById(id);
        if (DailyTripDetailsBean == null) {
            return new ResponseEntity<DailyTripDetailsBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DailyTripDetailsBean>(DailyTripDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createDailyTripDetailsBean(@RequestBody DailyTripDetailsBean DailyTripDetailsBean, UriComponentsBuilder ucBuilder){
	     //System.out.println("Creating DailyTripDetailsBean "+DailyTripDetailsBean.getName());
	     dailyTripDetailsService.createDailyTripDetails(DailyTripDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/dailytrip/{id}").buildAndExpand(DailyTripDetailsBean.getTripId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<DailyTripDetailsBean> getAllDailyTripDetailsBean() {	 
	  List<DailyTripDetailsBean> tasks=dailyTripDetailsService.getDailyTripDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateDailyTripDetailsBean(@RequestBody DailyTripDetailsBean currentDailyTripDetailsBean)
	{
		System.out.println("sd");
	DailyTripDetailsBean DailyTripDetailsBean = dailyTripDetailsService.findById(currentDailyTripDetailsBean.getTripId());
	if (DailyTripDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	dailyTripDetailsService.update(currentDailyTripDetailsBean, currentDailyTripDetailsBean.getTripId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<DailyTripDetailsBean> deleteDailyTripDetailsBean(@PathVariable("id") int id){
		DailyTripDetailsBean DailyTripDetailsBean = dailyTripDetailsService.findById(id);
		if (DailyTripDetailsBean == null) {
			return new ResponseEntity<DailyTripDetailsBean>(HttpStatus.NOT_FOUND);
		}
		dailyTripDetailsService.deleteDailyTripDetailsById(id);
		return new ResponseEntity<DailyTripDetailsBean>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<DailyTripDetailsBean> updateDailyTripDetailsBeanPartially(@PathVariable("id") int id, @RequestBody DailyTripDetailsBean currentDailyTripDetailsBean){
		DailyTripDetailsBean DailyTripDetailsBean = dailyTripDetailsService.findById(id);
		if(DailyTripDetailsBean ==null){
			return new ResponseEntity<DailyTripDetailsBean>(HttpStatus.NOT_FOUND);
		}
		DailyTripDetailsBean usr =	dailyTripDetailsService.updatePartially(currentDailyTripDetailsBean, id);
		return new ResponseEntity<DailyTripDetailsBean>(usr, HttpStatus.OK);
	}*/
}
