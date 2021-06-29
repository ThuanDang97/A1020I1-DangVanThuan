package model.repository.customer;

import model.bean.customer.Customer;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select customer_id, customer_type.customer_type_name as type_customer, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address\n" +
                            "from customer\n" +
                            "left join customer_type on customer_type.customer_type_id = customer.customer_type_id;"
            );
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeName(resultSet.getString("type_customer"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select customer_type.customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address\n" +
                            "from customer\n" +
                            "left join customer_type on customer_type.customer_type_id = customer.customer_type_id\n" +
                            "where customer_id = ?;"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerType(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "delete from customer where customer_id =?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "update customer\n" +
                            "set customer.customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ?\n" +
                            "where customer_id = ?"
            );
            preparedStatement.setInt(1, customer.getCustomerType());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setDate(3, customer.getCustomerBirthday());
            preparedStatement.setBoolean(4, customer.isCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "insert into customer (customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)" +
                            "values (?,?,?,?,?,?,?,?);"
            );
            preparedStatement.setInt(1, customer.getCustomerType());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setDate(3, customer.getCustomerBirthday());
            preparedStatement.setBoolean(4, customer.isCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findCustomer(String name) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select customer_id, customer_type.customer_type_name as type_customer, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address\n" +
                            "from customer\n" +
                            "left join customer_type on customer_type.customer_type_id = customer.customer_type_id\n" +
                            "where customer_name like '%' ? '%';"
            );
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeName(resultSet.getString("type_customer"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}
