package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> itemsList = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItemsList() {
        return itemsList;
    }

    public void addItem(OrderItem item){
        itemsList.add(item);
    }

    public void removeItem(OrderItem item){
        itemsList.remove(item);
    }

    public double total(){
        double sum = 0;
        for(OrderItem item : itemsList){
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMARY:\n");
        sb.append("Order moment: " + sdf.format(getMoment()) + "\n");
        sb.append("Order status: " + getStatus() + "\n");
        sb.append("Client: " + getClient() + "\n");
        sb.append("Order items:\n");
        for(OrderItem item : itemsList){
            sb.append(item + "\n");
        }
        sb.append("Total price: " + String.format("%.2f", total()));
        return sb.toString();
    }
}
