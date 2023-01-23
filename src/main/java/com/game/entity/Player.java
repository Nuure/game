package com.game.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "player")
public class Player {
    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.IDENTITY
    private Long id;
    //    @Column(name = "name")
    private String name;
    //    @Column(name = "title")
    private String title;
    //    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private Race race;
    //    @Column(name = "profession")
    @Enumerated(EnumType.STRING)
    private Profession profession;
    //    @Column(name = "experience")
    private Integer experience;
    //    @Column(name = "level")
    private Integer level;
    //    @Column(name = "untilNextLevel")
    private Integer untilNextLevel;
    //    @Column(name = "birthday")
    private Date birthday;
    //    @Column(name = "banned")
    private Boolean banned;


    public Player(Long id, String name, String title, Race race, Profession profession, Integer experience, Integer level, Integer untilNextLevel, Date birthday, Boolean banned) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.race = race;
        this.profession = profession;
        this.experience = experience;
        this.level = level;
        this.untilNextLevel = untilNextLevel;
        this.birthday = birthday;
        this.banned = banned;
    }

    public Player() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getUntilNextLevel() {
        return untilNextLevel;
    }

    public void setUntilNextLevel(Integer untilNextLevel) {
        this.untilNextLevel = untilNextLevel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean isBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }
}



//package com.game.entity;
//
//import org.springframework.context.annotation.Bean;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "player")
//public class Player {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String title;
//    @Enumerated(EnumType.STRING)
//    private Race race;
//    @Enumerated(EnumType.STRING)
//    private Profession profession;
//    private Integer experience;
//    private Integer level;
//    private Integer untilNextLevel;
//    private Date birthday;
//    private Boolean banned;
//
//    public Player(Long id, String name, String title, Race race,
//                  Profession profession, Integer experience, Integer level,
//                  Integer untilNextLevel, Date birthday, Boolean banned) {
//        this.id = id;
//        this.name = name;
//        this.title = title;
//        this.race = race;
//        this.profession = profession;
//        this.experience = experience;
//        this.level = level;
//        this.untilNextLevel = untilNextLevel;
//        this.birthday = birthday;
//        this.banned = banned;
//    }
//
//    protected Player() {
//
//    }
//
//    private Integer calculateLevel(Integer experience) {
//        Long l = Math.round((Math.sqrt(2500 + 200*experience)-50)/100);
//        return l.intValue();
//    }
//
//    private Integer calculateUntilNextLevel(Integer level, Integer experience) {
//        return 50*(level+1)*(level+2)-experience;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setRace(Race race) {
//        this.race = race;
//    }
//
//    public void setProfession(Profession profession) {
//        this.profession = profession;
//    }
//
//    public void setExperience(Integer experience) {
//        this.experience = experience;
//    }
//
//    public void setLevel(Integer level) {
//        this.level = level;
//    }
//
//    public void setUntilNextLevel(Integer untilNextLevel) {
//        this.untilNextLevel = untilNextLevel;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public void setBanned(Boolean banned) {
//        this.banned = banned;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public Race getRace() {
//        return race;
//    }
//
//    public Profession getProfession() {
//        return profession;
//    }
//
//    public Integer getExperience() {
//        return experience;
//    }
//
//    public Integer getLevel() {
//        return level;
//    }
//
//    public Integer getUntilNextLevel() {
//        return untilNextLevel;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public Boolean getBanned() {
//        return banned;
//    }
//}
