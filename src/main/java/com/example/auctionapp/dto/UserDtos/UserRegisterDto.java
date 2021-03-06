package com.example.auctionapp.dto.UserDtos;

import com.example.auctionapp.dto.BaseResourceDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UserRegisterDto extends BaseResourceDto {

    @NotBlank(message = "First name can't be blank")
    @Pattern(regexp = "([A-Za-z0-9\\-\\s]*)")
    private String firstName;

    @NotBlank(message = "Last name can't be blank")
    @Pattern(regexp = "([A-Za-z0-9\\-\\s]*)")
    private String lastName;

    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password can't be blank")
    @Size(min = 5)
    private String password;

    @NotBlank
    private String imageUrl;

    public UserRegisterDto() {
    }

    public UserRegisterDto(Long id,
                   LocalDateTime dateCreated,
                   LocalDateTime lastModifiedDate,
                   String firstName,
                   String lastName, String email,
                   String password) {
        super(id, dateCreated, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserRegisterDto(Long id,
                   LocalDateTime dateCreated,
                   LocalDateTime lastModifiedDate,
                   String firstName,
                   String lastName,
                   String email,
                   Long roleId,
                   String imageUrl) {
        super(id, dateCreated, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
