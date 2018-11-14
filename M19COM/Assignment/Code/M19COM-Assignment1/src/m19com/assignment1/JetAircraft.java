/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m19com.assignment1;

/**
 *
 * @author rollingc
 */
public class JetAircraft extends Aircraft {
    
    public JetAircraft(String name, int flights, String reg, String ntype) {
        super(name, flights, reg);
        type = ntype;
    }
    
}
