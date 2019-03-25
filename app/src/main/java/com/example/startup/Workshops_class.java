package com.example.startup;

import com.google.firebase.database.Exclude;
public class Workshops_class {


        private String topic;
        private String facilitator;
        private String time;
        private String currentlyEnrolled;//mitko
        private String capacityOfWorkshop;
        private String key;
        private String imageURL;
        private String description;
        private int position;

        public Workshops_class() {
            //empty constructor needed
        }
        public Workshops_class (int position){
            this.position = position;
        }
        public Workshops_class(String imageURL,String topic, String facilitator ,String time,String currentlyEnrolled,String capacityOfWorkshop) {
            this.imageURL = imageURL;
            this.topic = topic;
            this.facilitator = facilitator;
            this.time = time;
            this.currentlyEnrolled = currentlyEnrolled;
            this.capacityOfWorkshop = capacityOfWorkshop;
        }
        public Workshops_class(String imageURL,String topic, String facilitator ,String time,String currentlyEnrolled,String capacityOfWorkshop,String description){
            this.imageURL = imageURL;
            this.topic = topic;
            this.facilitator = facilitator;
            this.time = time;
            this.currentlyEnrolled = currentlyEnrolled;
            this.capacityOfWorkshop = capacityOfWorkshop;
            this.description = description;
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
        public String getTime() {return time;}
        public void setTime(String time)
        {
            this.time = time;
        }
        public String getCurrentlyEnrolled() {return currentlyEnrolled;}

        public String getDescription() {
        return description;
        }

        public void setDescription(String description) {
        this.description = description;
        }

        public void setCurrentlyEnrolled(String currentlyEnrolled)
        {
            this.currentlyEnrolled = currentlyEnrolled;
        }
        public String getCapacityOfWorkshop() {return capacityOfWorkshop;}
        public void setCapacityOfWorkshop(String capacityOfWorkshop)
        {
            this.capacityOfWorkshop = capacityOfWorkshop;
        }
        public String getImageUrl() {
        return imageURL;
    }
        public void setImageUrl(String imageUrl) {
        this.imageURL = imageUrl;
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
