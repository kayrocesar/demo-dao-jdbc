package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		System.out.println("------------TEST 1 : SELLER  findById--------------");
		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n------------TEST 2 : SELLER  findByDepartment--------------");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {

			System.out.println(obj);
		}
		System.out.println("\n------------TEST 3 : SELLER  findByAll--------------");

		
		 list = sellerDao.findAll();

		for (Seller obj : list) {

			System.out.println(obj);
		}
		
		System.out.println("\n------------TEST 4 : SELLER  insert--------------");

		
		Seller newSeller= new Seller(null,"Greg","greg@gmail.com",new Date(),400.0,department);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id = " + newSeller.getId());

		
		System.out.println("\n------------TEST 5 : SELLER  update--------------");
		seller=sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}

}
