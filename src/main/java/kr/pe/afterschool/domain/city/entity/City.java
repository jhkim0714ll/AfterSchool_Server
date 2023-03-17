package kr.pe.afterschool.domain.city.entity;

import kr.pe.afterschool.domain.country.entity.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "city")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_country_id")
    private Country country;

    public void editCity(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @Builder
    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
