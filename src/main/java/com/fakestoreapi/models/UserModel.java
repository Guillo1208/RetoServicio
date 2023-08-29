package com.fakestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserModel {

    @JsonProperty ("email")
    public String email;

    @JsonProperty ("username")
    public String username;

    @JsonProperty ("password")
    public String password;

    @JsonProperty ("name")
    public List<Name> name;

    @JsonProperty ("address")
    public List<Address> address;

    @JsonProperty ("phone")
    public String phone;

}
