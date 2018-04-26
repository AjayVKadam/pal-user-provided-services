package io.pivotal.pal.paluserprovidedservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/")
    public List<Cohort> home() {
        //return "Hello PALs from Wells Fargo in Des Moines";

        List<Cohort> list = getUsers();

        return list;
        //String allNames = convertToString(list);

        //return allNames;
    }


    String convertToString(List<Cohort> list) {
        StringBuffer allNames = new StringBuffer();

        for (Cohort cohort: list) {

            allNames.append(  cohort.getName() + " ;");
        }

        return allNames.toString();
    }



    List<Cohort> getUsers() {

        JdbcTemplate jdbcTempLate = new JdbcTemplate(dataSource);

        String sql = "select * from cohort";

        List<Cohort> cohortList = new ArrayList<Cohort>();

        List<Map<String, Object>> maps = jdbcTempLate.queryForList(sql);
        for (Map row : maps) {
            Cohort cohort = new Cohort();
            cohort.setId((Integer) (row.get("id")));
            cohort.setName((String)row.get("name"));
            cohort.setNickname((String)row.get("nickname"));
            cohortList.add(cohort);
        }

        return cohortList;
    }

}
