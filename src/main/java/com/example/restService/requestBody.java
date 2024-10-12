package com.example.restService;

public class requestBody {
    public static class AddEmployeeRequest {
        private Integer employee_id;
        private String first_name;
        private String last_name;
        private String email;
        private String title;

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getTitle() {
            return title;
        }

        public String getEmail() {
            return email;
        }

        public Integer getEmployee_id() {
            return employee_id;
        }
    }
}
