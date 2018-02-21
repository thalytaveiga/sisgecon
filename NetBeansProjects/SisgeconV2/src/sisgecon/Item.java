/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgecon;

/**
 *
 * @author thalytaveiga
 */
public class Item {

        private Integer id;
        private String description;

    public Item() {
    }
        
        public Item(Integer id, String description) {
            this.id = id;
            this.description = description;
        }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }






    

        public Integer getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return description;
        }
}
