package dz.elit.interceptor;

import org.hibernate.EmptyInterceptor;

public class Interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
//        System.out.println("------------------------" + sql);
//        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select") /*&&
//                !sql.toLowerCase().contains("select nextval")*/) {
//            String entityName = sql.substring(7, sql.indexOf("."));//exemple select utilisateu0_.
//            String idEntreprise = MDC.get("idEntreprise");
//
//            if (StringUtils.hasLength(entityName)
//                    && !sql.toLowerCase().contains("idEntreprise")
//                    && !sql.toLowerCase().contains("role")
//                    && StringUtils.hasLength(idEntreprise)) {
//                if (sql.toLowerCase().contains("where")) {
//                    sql = sql + " and " + entityName + ".id_entreprise = " + idEntreprise;
//                } else {
//                    sql = sql + " where " + entityName + ".id_entreprise = " + idEntreprise;
//                }
//            }
//        }
       return super.onPrepareStatement(sql);
    }
}
