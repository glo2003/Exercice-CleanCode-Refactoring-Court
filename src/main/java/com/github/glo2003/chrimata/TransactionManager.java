package com.github.glo2003.chrimata;

import java.util.*;

/// transaction manager
public class TransactionManager {

    /// a class
    static class StringFloat {
        public String string; // a string
        public float _float; // a float
    }

    /// data
    public Map<String, Map<String, List<StringFloat>>> cs;

    /// constructor
    TransactionManager() {
        cs = new HashMap<String, Map<String, List<StringFloat>>>(); // create cs
    }


    /// register company
    public void regCie(String cName) {
        cs.put(cName, new HashMap<String, List<StringFloat>>()); // put it here
    }

    /// register user
    public void Registeruser(String c, String uname) {
        boolean b = false; // a boolean
        Map<String, List<StringFloat>> c2 = cs.get(c);
        b = c2 == null; // boolean used here (true if c2 == null)
        boolean b2 = !b && !(c2.get(uname) == null); // true if name is not in map
        if (b2) {
            // yes name in map

            c2.put(uname, new ArrayList<StringFloat>());

        } else {
            throw new RuntimeException("cannot do that");
        }
    }

    /// user buy a product
    public void uBuy_a_product(String uName, String panme, float p, String cname) {
        // try this
        try {
            StringFloat sf = new StringFloat();
            sf.string = panme; sf._float = p;
            cs.get(cname).get(uName).add(sf);
        } catch (Exception e) { // if it throws an exception
            throw new RuntimeException("error"); // oh no, error
        }
    }

    /// reject expense
    public void reject_expense(String username, String c, String producttname) {
        try {
            cs.get(c).get(username).removeIf(l -> l.string.equals(producttname));
        } catch (Exception ex) {
            throw new RuntimeException("cannot do that"); // exception
        }
    }

    // report
    public static class Report {
        public static class OneReport {
            public String cname;
            public Map<String,Float>  u2p;
            public float t;
        }
        List<OneReport> report;
    }

    /// todo remove that
    public static void test() {
        /// used to test some code
        TransactionManager tm = new TransactionManager();
        tm.regCie("google");
        tm.Registeruser("google", "alice");
        tm.uBuy_a_product("alice", "laptop", 2000, "google");
        tm.uBuy_a_product("alice", "restaurent", 50, "google");
        tm.reject_expense("alice", "google", "restaurent");
        tm.gen_a_ReportFor("google");
        tm.genrepAll();
        // if no exception, all good
    }

    /// gen_a_ReportFor
    public Report.OneReport gen_a_ReportFor(String n) {
        Report.OneReport o = new Report.OneReport();
        Map<String, List<StringFloat>> stringListMap = cs.get(n);

        float t = 0;
        Map<String, Float> u2p  = new HashMap<>();

        o.cname = n;
        for (String k : stringListMap.keySet()) {
            List<StringFloat> list = stringListMap.get(k);
            u2p.put(k, (float) 0);
            for (int i = 1; i <= list.size(); ++i) {
                StringFloat sf = list.get(i - 1);
                t += sf._float;
                u2p.computeIfPresent(k, (a, b) -> b += sf._float);
            }
        }
        o.t = t;
        o.u2p = u2p;
        return o;
    }

    /// gen rep all
    public Report genrepAll() {
        Report r = new Report();
        for (String n : this.cs.keySet()) {
            if (r.report == null) {
                r.report = new ArrayList<>();
            }
            // copied from gen_a_ReportFor
            Report.OneReport o = new Report.OneReport();
            Map<String, List<StringFloat>> stringListMap = cs.get(n);

            float t = 0;
            Map<String, Float> u2p  = new HashMap<>();

            o.cname = n;
            for (String k : stringListMap.keySet()) {
                List<StringFloat> list = stringListMap.get(k);
                u2p.put(k, (float) 0);
                for (int i = 1; i <= list.size(); ++i) {
                    StringFloat sf = list.get(i - 1);
                    t += sf._float;
                    u2p.computeIfPresent(k, (a, b) -> b += sf._float);
                }
            }
            o.t = t;
            o.u2p = u2p;
            r.report.add(o);
        }
        return r;
    }
}
