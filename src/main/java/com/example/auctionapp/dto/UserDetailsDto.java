package com.example.auctionapp.dto;


import java.time.LocalDate;

public class UserDetailsDto {

    private String phoneNumber;

    private Long birthDate;

    private String gender;

    private AddressDto address;

    private CardInformationDto cardInformation;

    public UserDetailsDto() {
    }

    public UserDetailsDto(String phoneNumber,
                          Long birthDate,
                          String gender,
                          AddressDto address,
                          CardInformationDto cardInformation) {
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.cardInformation = cardInformation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public CardInformationDto getCardInformation() {
        return cardInformation;
    }

    public void setCardInformation(CardInformationDto cardInformation) {
        this.cardInformation = cardInformation;
    }
}
