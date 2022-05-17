package com.rakharafifa.miniproject.controller;

import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateAddressDTO;
import com.rakharafifa.miniproject.model.dto_get.AddressDto;
import com.rakharafifa.miniproject.model.entity.Address;
import com.rakharafifa.miniproject.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniproject/address")
public class AddressController {
    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> addresss = addressService.getAllAddress();
        return new ResponseEntity<>(addresss, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<AddressDto>> getAllAddressDto(){
        List<AddressDto> addressDtos = addressService.getAllAddressDto();
        return new ResponseEntity<>(addressDtos, HttpStatus.OK);
    }

    @GetMapping("/{address_id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("address_id") Long address_id){
        return new ResponseEntity<>(addressService.getAddressById(address_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateAddressDTO> createAddress(@RequestBody CreateAddressDTO createAddressDTO){
        addressService.createAddressDto(createAddressDTO);
        return new ResponseEntity<>(createAddressDTO, HttpStatus.OK);
    }

    @PutMapping("/{address_id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("address_id") Long address_id, @RequestBody Address address){
        addressService.updateAddress(address_id, address);
        return new ResponseEntity<>(addressService.getAddressById(address_id), HttpStatus.OK);
    }

    @DeleteMapping("/{address_id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable("address_id") Long address_id){
        addressService.deleteAddress(address_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
