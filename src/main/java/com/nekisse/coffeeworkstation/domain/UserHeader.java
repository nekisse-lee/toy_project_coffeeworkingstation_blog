package com.nekisse.coffeeworkstation.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHeader {

    String profileImgUrl;

    String title;

    String desc;

    public UserHeader(String profileImgUrl, String title, String desc) {
        this.profileImgUrl = profileImgUrl;
        this.title = title;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UserHeader{" +
                "profileImgUrl='" + profileImgUrl + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
