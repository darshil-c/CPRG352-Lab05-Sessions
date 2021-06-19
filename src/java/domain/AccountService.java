/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class AccountService {
    private String userAdam = "adam";
    private String userBetty = "betty";
    private String password = "password";
    
    public User login(String username, String password) {
        if ((username.equals(userAdam) && password.equals(this.password)) || (username.equals(userBetty) && password.equals(this.password))) {
            return new User(username, null);
        }
        else {
            return null;
        }
    }
}
