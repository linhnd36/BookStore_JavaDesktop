<%@page import="com.paypal.api.payments.Transaction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Payment Receipt</title>
        <style type="text/css">
            table { border: 0; }
            table td { padding: 5px; }
        </style>
    </head>
    <body>
        <div align="center">
            <h1 style="color: red">Payment Done. Thank you for purchasing our products</h1>
            <br/>
            <h2>Receipt Details:</h2>
            <table>
                <tr>
                    <td><b>Payer:</b></td>
                    <td>${payer.firstName} ${payer.lastName}</td>      
                </tr>
                <tr>
                    <td><b>Build ID:</b></td>
                    <td><% Transaction transaction = (Transaction) request.getAttribute("transaction");%>
                        <%= transaction.getDescription() %>
                        </td>
                </tr>
                <tr>
                    <td><b>Total:</b></td>
                    <td>${transaction.amount.total} USD</td>
                </tr>                    
            </table>
        </div>
    </body>
</html>
