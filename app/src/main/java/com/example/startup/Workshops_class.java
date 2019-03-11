package com.example.startup;

import com.google.firebase.database.Exclude;
public class Workshops_class {


        private String topic;
        private String facilitator;
        private String company;
        private String time;
        private String currentlyEnrolled;//mitko
        private String capacityOfWorkshop;
        private String key;
        private int position;

        public Workshops_class() {
            //empty constructor needed
        }
        public Workshops_class (int position){
            this.position = position;
        }
        public Workshops_class(String topic, String facilitator ,String company,String time,String currentlyEnrolled,String capacityOfWorkshop) {
            this.topic = topic;
            this.facilitator = facilitator;
            this.company = company;
            this.time = time;
            this.currentlyEnrolled = currentlyEnrolled;
            this.capacityOfWorkshop = capacityOfWorkshop;
        }
        public String getTopic() {
            return topic;
        }
        public void setTopic(String topic)
        {
            this.topic = topic;
        }
        public String getFacilitator() {return facilitator;}
        public void setFacilitator(String facilitator)
        {
            this.facilitator = facilitator;
        }
        public String getCompany() {return company;}
        public void setCompany(String company)
        {
            this.company = company;
        }
        public String getTime() {return time;}
        public void setTime(String time)
        {
            this.time = time;
        }
        public String getCurrentlyEnrolled() {return currentlyEnrolled;}
        public void setCurrentlyEnrolled(String currentlyEnrolled)
        {
            this.currentlyEnrolled = currentlyEnrolled;
        }
        public String getCapacityOfWorkshop() {return capacityOfWorkshop;}
        public void setCapacityOfWorkshop(String capacityOfWorkshop)
        {
            this.capacityOfWorkshop = capacityOfWorkshop;
        }


        @Exclude
        public String getKey() {
            return key;
        }
        @Exclude
        public void setKey(String key) {
            this.key = key;
        }
}
