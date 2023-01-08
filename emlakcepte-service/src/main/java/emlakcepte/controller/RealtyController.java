package emlakcepte.controller;

import java.util.List;

import emlakcepte.dto.model.response.RealtyResponse;
import emlakcepte.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakcepte.model.Realty;
import emlakcepte.dto.model.request.RealtyRequest;
import emlakcepte.service.RealtyService;

import javax.ws.rs.Path;

@RestController
@RequestMapping(value = "/realties")
public class RealtyController {

    private RealtyService realtyService;

    public RealtyController(RealtyService realtyService) {
        this.realtyService = realtyService;
    }

    @GetMapping
    public ResponseEntity<List<RealtyResponse>> getAll() {
        return ResponseEntity.ok(realtyService.getAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<List<RealtyResponse>> getAllByUserId(@PathVariable int id) {
        List<RealtyResponse> realtyes = realtyService.getAllById(id);
        return ResponseEntity.ok(realtyes);
    }

    @GetMapping(value = "/status/active")
    public ResponseEntity<List<RealtyResponse>> getAllActiveRealtyes() {
        List<RealtyResponse> realtyes = realtyService.getAllActiveRealtyes();
        return ResponseEntity.ok(realtyes);
    }

    @GetMapping(value = "/getRealtyByUserId")
    public ResponseEntity<RealtyResponse> getRealtyByUserId(@RequestParam Integer userId, @RequestParam Integer realtyId) {
        return ResponseEntity.ok(realtyService.getRealtyByUserId(userId, realtyId));
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<List<RealtyResponse>> getActiveRealtyByUserName(@PathVariable Integer id) {
        return ResponseEntity.ok(realtyService.getActiveRealtyByUserId(id));
    }

    @PostMapping
    public ResponseEntity<RealtyResponse> create(@RequestBody RealtyRequest realtyRequest) throws Exception {
        RealtyResponse realty = realtyService.create(realtyRequest);
        return new ResponseEntity<>(realty, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{realtyId}")
    public ResponseEntity<Integer> delete(@PathVariable Integer realtyId) {

        realtyService.delete(realtyId);
        return ResponseEntity.ok(realtyId);

    }

    @PutMapping(value = "/{realtyId}")
    public ResponseEntity<RealtyResponse> update(@PathVariable Integer realtyId, @RequestBody RealtyRequest realtyRequest) {
        return ResponseEntity.ok(realtyService.update(realtyId, realtyRequest));
    }

    @GetMapping("/change/{id}")
    public RealtyResponse changeStatusOfRealty(@PathVariable Integer id) {
        return realtyService.changeStatusOfRealty(id);
    }

    @GetMapping("/details/{province}")
    public void getAllByProvince(String province) {
        realtyService.getAllByProvince(province);
    }


}
