package com.htv.nttv.pojo;

import com.htv.nttv.pojo.UserTeam;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, Integer> number;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile SingularAttribute<Team, String> description;
    public static volatile SingularAttribute<Team, Integer> id;
    public static volatile CollectionAttribute<Team, UserTeam> userTeamCollection;

}