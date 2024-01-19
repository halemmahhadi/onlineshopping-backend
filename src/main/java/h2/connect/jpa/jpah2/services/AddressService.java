package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.AddressNotFoundException;
import h2.connect.jpa.jpah2.model.Address;
import h2.connect.jpa.jpah2.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAddress() {
        return StreamSupport
                .stream(addressRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Address getAddressById(long address_id) {
        return addressRepository.findById(address_id).orElseThrow(() ->
                new AddressNotFoundException(address_id));
    }

    public Address deleteAddress(long address_id) {
        Address address = getAddressById(address_id);// if exist
        addressRepository.delete(address);
        return address;

    }

    public Address editAddress(long address_id, Address address) {
        Address addressToEdit = getAddressById(address_id);
        addressToEdit.setStreet(address.getStreet());
        addressToEdit.setStreet_number(address.getStreet_number());
        addressToEdit.setZipcode(address.getZipcode());
        addressToEdit.setCity(address.getCity());
        addressToEdit.setCountry(address.getCountry());
        addressToEdit.setPhone(address.getPhone());
        return addressToEdit;
    }


}
