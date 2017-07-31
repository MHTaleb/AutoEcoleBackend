/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meta;

import com.talcorpdz.autoecole.usermanagement.dao.AccountMetier;
import com.talcorpdz.autoecole.usermanagement.dao.AccountMetierLocal;
import entity.Account;
import java.util.List;

/**
 *
 * @author taleb
 */
public class Run {
    public static void main(String[] args) {
        AccountMetierLocal aml = new AccountMetier();
        List<Account> listerToutLesComptes = aml.listerToutLesComptes();
    }
}
