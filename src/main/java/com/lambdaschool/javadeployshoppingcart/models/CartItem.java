package com.lambdaschool.javadeployshoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CartItemId.class)
@Table(name = "cartitems")
public class CartItem
    extends Auditable
    implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "carts",
        allowSetters = true)
    private com.lambdaschool.javadeployshoppingcart.models.User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties(value = "carts",
        allowSetters = true)
    private com.lambdaschool.javadeployshoppingcart.models.Product product;

    private long quantity;

    private String comments;

    public CartItem()
    {

    }

    public CartItem(
        com.lambdaschool.javadeployshoppingcart.models.User user,
        com.lambdaschool.javadeployshoppingcart.models.Product product,
        long quantity,
        String comments)
    {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.comments = comments;
    }

    public com.lambdaschool.javadeployshoppingcart.models.User getUser()
    {
        return user;
    }

    public void setUser(com.lambdaschool.javadeployshoppingcart.models.User user)
    {
        this.user = user;
    }

    public com.lambdaschool.javadeployshoppingcart.models.Product getProduct()
    {
        return product;
    }

    public void setProduct(com.lambdaschool.javadeployshoppingcart.models.Product product)
    {
        this.product = product;
    }

    public long getQuantity()
    {
        return quantity;
    }

    public void setQuantity(long quantity)
    {
        this.quantity = quantity;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        CartItem that = (CartItem) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
            ((product == null) ? 0 : product.getProductid()) == ((that.product == null) ? 0 : that.product.getProductid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
