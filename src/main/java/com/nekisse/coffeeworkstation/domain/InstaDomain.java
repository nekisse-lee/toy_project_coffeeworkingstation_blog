package com.nekisse.coffeeworkstation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InstaDomain {

    String desc;
    String imgUrl;

    public InstaDomain() {
    }

    public InstaDomain(String desc, String imgUrl) {
        this.desc = desc;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "InstaDomain{" +
                "description='" + desc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
