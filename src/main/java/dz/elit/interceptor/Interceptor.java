package dz.elit.interceptor;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {
// @Override
// public String onPrepareStatement(String sql) {
//     return super.onPrepareStatement(sql);
// }

    //shit+T
    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("je suis dans l'intecepeteur ");
        if (StringUtils.hasLength(sql) && sql.startsWith("select")) {
            if(sql.contains("category"))// à verifier
            if (sql.contains("where")) {
                sql = sql + " and id_entreprise=1";
            } else {
                sql = sql +" where id_entreprise = 1";
            }
        }
        return super.onPrepareStatement(sql);
    }
}
