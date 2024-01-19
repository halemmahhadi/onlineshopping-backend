package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.Address;
import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.model.dto.AddressDto;
import h2.connect.jpa.jpah2.model.dto.CustomerDto;
import h2.connect.jpa.jpah2.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {
     private  final AddressService addressService;
     @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping
    public ResponseEntity<AddressDto> addAddress(@RequestBody final AddressDto addressDto) {
        Address address = addressService.addAddress(Address.from(addressDto));
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddress() {
        List<Address> address = addressService.getAddress();
        List<AddressDto> addressDto = address.stream().map(AddressDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable final long id) {
       Address address = addressService.getAddressById(id);
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);

    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<AddressDto> deleteAddress(@PathVariable final long id) {
        Address address = addressService.deleteAddress(id);
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AddressDto> editAddresss(@PathVariable final long id, @RequestBody final AddressDto addressDto) {
        Address editedAddress = addressService.editAddress(id, Address.from(addressDto));
        return new ResponseEntity<>(AddressDto.from(editedAddress), HttpStatus.OK);
    }

}
