package com.PayToPay.application.dao;

import com.PayToPay.application.dao.transactionDao.TransactionDAO;

public class DAOFactory {
    private static TransactionDAO transactionDAO = new TransactionDAO();

    public static TransactionDAO getTransactionDAO(){return transactionDAO;}
}
