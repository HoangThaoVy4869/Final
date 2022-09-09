package com.htv.nttv.pojo;

import com.htv.nttv.pojo.Team;
import com.htv.nttv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(UserTeam.class)
public class UserTeam_ { 

    public static volatile SingularAttribute<UserTeam, Team> teamId;
    public static volatile SingularAttribute<UserTeam, Integer> id;
    public static volatile SingularAttribute<UserTeam, User> userId;

}