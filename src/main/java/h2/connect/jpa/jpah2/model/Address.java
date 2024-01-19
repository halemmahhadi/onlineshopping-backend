package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.AddressDto;

import javax.persistence.*;

@Entity
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long address_id;
    private String street;
    private String street_number;
    private int zipcode;
    private String city;
    private  String country;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "address")
    private Orders orders;


    public Address() {
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getAddress_id() {
        return address_id;
    }

    public String getStreet() {
        return street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Address from(AddressDto addressDto){
        Address address=new Address();
        address.setStreet(addressDto.getStreet());
        address.setStreet_number(addressDto.getStreet_number());
        address.setZipcode(addressDto.getZipcode());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setPhone(addressDto.getPhone());
        return address;
    }
}

