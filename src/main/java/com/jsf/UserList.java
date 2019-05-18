package com.jsf;

import com.jsf.helper.UserHelper;
import com.jsf.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name="userList")
@SessionScoped
public class UserList implements Serializable
{

    private static ArrayList<User> users = UserHelper.listOfUsers();
    private boolean sortAscending = true;
    private Date fromDate;
    private Date toDate;


    public ArrayList<User> getUsers()
    {
        return users;
    }

    public String deleteUser(User user) {
        users.remove(user);
        return null;
    }

    public String editUser(User user) {
        user.setCanEdit(true);
        return null;
    }

    public String saveUsers()
    {
        users.forEach(user -> user.setCanEdit(false));
        return null;
    }

    public String filterUsers()
    {
        ArrayList<User> result = new ArrayList<>();
        Date dateFrom = getFromDate();
        Date dateTo = getToDate();

        for (User user : UserHelper.listOfUsers())
        {
            Date bornDate = user.getBirthDate();

            if(dateFrom != null && bornDate.before(dateFrom))
            {
                continue;
            }

            if(dateTo != null && bornDate.after(dateTo))
            {
                continue;
            }

            result.add(user);
        }

        users = result;
        return null;
    }


    public String sortByLogin() {

        if(sortAscending){

            //ascending order
            Collections.sort(users, new Comparator<User>() {

                @Override
                public int compare(User o1, User o2) {

                    return o1.getLogin().compareTo(o2.getLogin());

                }

            });
            sortAscending = false;

        }else{

            //descending order
            Collections.sort(users, new Comparator<User>() {

                @Override
                public int compare(User o1, User o2) {

                    return o2.getLogin().compareTo(o1.getLogin());

                }

            });
            sortAscending = true;
        }

        return null;
    }
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
