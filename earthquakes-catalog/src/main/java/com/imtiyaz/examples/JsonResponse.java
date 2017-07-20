package com.imtiyaz.examples;

public class JsonResponse {
    private String[] catalogs;
    private String[] contributors;
    private String[] producttypes;
    private String[] eventtypes;
    private String[] magnitudetypes;

    public String[] getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(String[] catalogs) {
        this.catalogs = catalogs;
    }

    public String[] getContributors() {
        return contributors;
    }

    public void setContributors(String[] contributors) {
        this.contributors = contributors;
    }

    public String[] getProducttypes() {
        return producttypes;
    }

    public void setProducttypes(String[] producttypes) {
        this.producttypes = producttypes;
    }

    public String[] getEventtypes() {
        return eventtypes;
    }

    public void setEventtypes(String[] eventtypes) {
        this.eventtypes = eventtypes;
    }

    public String[] getMagnitudetypes() {
        return magnitudetypes;
    }

    public void setMagnitudetypes(String[] magnitudetypes) {
        this.magnitudetypes = magnitudetypes;
    }
}
