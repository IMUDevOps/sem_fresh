package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{ /**
 * Connection to MySQL database.
 */
private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");

                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    public ArrayList<Country> getCountryByPopulationtop10()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * from country order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            ArrayList<Country> countries = new ArrayList<Country>();
           while (rset.next())
            {
                Country country = new Country();
                country.setCode( rset.getString("Code"));
                country.setName(rset.getString("Name"));
                country.setContinent(rset.getString("Continent"));
                country.setCapital(rset.getString("Capital"));
                country.setPopulation(rset.getInt("Population"));
                country.setRegion(rset.getString("Region"));
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Report No 1 country population of top ten
        ArrayList<Country> countries =a.getCountryByPopulationtop10();

        // Get Employee
       // Employee emp = a.getEmployee(255530);
        // Display results
      //  a.displayEmployee(emp);

        // Disconnect from database
        a.disconnect();
    }
    public void displayCountries(ArrayList<Country> countries)
    {
        System.out.println("Country Code"+"\t"+"Name"+"\t"+"Continent"+"\t"+"Region"+"\t"+ "Country Code");
        for(Country c: countries)
        {
            System.out.println(c.getCode()+"\t"+c.getName()+"\t"+c.getContinent()+"\t"+c.getRegion()+"\t"+c.getCode());
        }
    }
}