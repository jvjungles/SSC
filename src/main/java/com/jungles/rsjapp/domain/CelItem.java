package com.jungles.rsjapp.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A Item de Celular...
 */
@Entity
@Table(name = "cel_item")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CelItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "celitem_name")
    private String celItemName;
    
    @Column(name = "celitem_description")
    private String celItemDescription;
    
    @Column(name = "celitem_valor")
    private Long celItemValor;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CelItem id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCelItemName() {
        return celItemName;
    }
    
    public CelItem celItemName(String celItemName) {
        this.setCelItemName(celItemName);
        return this;
    }

    public void setCelItemName(String celItemName) {
        this.celItemName = celItemName;
    }
    
    public String getCelItemDescription() {
        return celItemDescription;
    }
    
    public CelItem celItemDescription(String celItemDescription) {
        this.setCelItemDescription(celItemDescription);
        return this;
    }

    public void setCelItemDescription(String celItemDescription) {
        this.celItemDescription = celItemDescription;
    }
    
    public Long getCelItemValor() {
        return celItemValor;
    }
    
    public CelItem celItemValor(Long celItemValor) {
        this.setCelItemValor(celItemValor);
        return this;
    }

    public void setCelItemValor(Long celItemValor) {
        this.celItemValor = celItemValor;
    }    

   // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CelItem)) {
            return false;
        }
        return id != null && id.equals(((CelItem) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "CelItem [id=" + id + ", celItemName=" + celItemName + ", celItemDescription=" + celItemDescription
                + ", celItemValor=" + celItemValor + "]";
    }    
}
