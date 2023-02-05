public class Show implements IShow {
        private String title;
        private int year;
        private int rating;
        String provider;

        public Show(String title, int year, int rating, String provider) {
                this.title = title;
                this.year = year;
                this.rating = rating;
                this.provider = provider;
        }

        @Override
        public int compareTo(IShow o) {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public String getTitle() {
                // TODO Auto-generated method stub
                return title;
        }

        @Override
        public int getYear() {
                // TODO Auto-generated method stub
                return year;
        }

        @Override
        public int getRating() {
                // TODO Auto-generated method stub
                return rating;
        }

        @Override
        public boolean isAvailableOn(String provider) {

                        if(this.provider.equals(provider)) {
                                return true;

                }
                return false;
        }

}