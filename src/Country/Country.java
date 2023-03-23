package Country;

import java.util.*;

public class Country {
	/*
	private String name;
    private String capital;
    private List<String> altSpellings;
    private String relevance;
    private String region;
    private String subregion;
    private int population;
    private List<String> languages;
    private Map<String, String> translations;
    private String demonym;
    private List<String> latlng;
    private String area;
    private String gini;
    private List<String> timezones;
    private List<String> borders;
    private String nativeName;
    private String numericCode;
    private List<String> currencies;
    private List<String> callingCodes;
    private String topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private Map<String, String> flags;
    private List<String> regionalBlocs;

    public Country(String name, String capital, List<String> altSpellings, String relevance,
            String region, String subregion, int population, List<String> languages,
            Map<String, String> translations, String demonym, List<String> latlng, String area,
            String gini, List<String> timezones, List<String> borders, String nativeName,
            String numericCode, List<String> currencies, List<String> callingCodes,
            String topLevelDomain, String alpha2Code, String alpha3Code, Map<String, String> flags,
            List<String> regionalBlocs) {
        this.name = name;
        this.capital = capital;
        this.altSpellings = altSpellings;
        this.relevance = relevance;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.languages = languages;
        this.translations = translations;
        this.demonym = demonym;
        this.latlng = latlng;
        this.area = area;
        this.gini = gini;
        this.timezones = timezones;
        this.borders = borders;
        this.nativeName = nativeName;
        this.numericCode = numericCode;
        this.currencies = currencies;
        this.callingCodes = callingCodes;
        this.topLevelDomain = topLevelDomain;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.flags = flags;
        this.regionalBlocs = regionalBlocs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
	*/
	
//  *************   Attribute Name    *****************************************
	private Name name;
	public void set_name(Name name) {
        this.name = name;
    }
    public Name get_name() {
        return name;
    }
    //  *************   Class Name    *****************************************
    public static class Name {
    	//  *************   Attribute Common    *****************************************
        private String common;
        public void set_common(String common) {
            this.common = common;
        }
        public String get_common() {
            return common;
        }
        //  *************   Attribute Official    *****************************************
        private String official;
        public void set_official(String official) {
            this.official = official;
        }
        public String get_official() {
            return official;
        }
        //  *************   Attribute NativeName    *****************************************
        private NativeName nativeName;
        public void set_nativeName(NativeName nativeName) {
            this.nativeName = nativeName;
        }
        public NativeName get_nativeName() {
            return nativeName;
        }
        //  *************   NativeName Class    *****************************************
        public static class NativeName {
        	//  *************   Attribute Spa    *****************************************
            private Language spa;
            public Language getSpanish() {
                return spa;
            }
            public void setSpanish(Language spa) {
                this.spa = spa;
            }
        }
        /*public Name(String common, String official, NativeName nativeName) {
        this.common = common;
        this.official = official;
        this.nativeName = nativeName;
    }*/
    }

//  *************   Attribute tld    *****************************************
	List<String> tld = new ArrayList<>();
	public void set_tld(List<String> tld) {
        this.tld = tld;
    }
    public List<String> get_tld() {
        return tld;
    }
    
//  *************   Attribute cca2    *****************************************
	String cca2;
	public void set_cca2(String cca2) {
        this.cca2 = cca2;
    }
    public String get_cca2() {
        return cca2;
    }
    
//  *************   Attribute ccn3    *****************************************
	int ccn3;
	public void set_ccn3(int ccn3) {
        this.ccn3 = ccn3;
    }
    public int get_ccn3() {
        return ccn3;
    }
    
//  *************   Attribute cca3    *****************************************
	String cca3;
	public void set_cca3(String cca3) {
        this.cca3 = cca3;
    }
    public String get_cca3() {
        return cca3;
    }
    
//  *************   Attribute cioc    *****************************************
	String cioc;
	public void set_cioc(String cioc) {
        this.cioc = cioc;
    }
    public String get_cioc() {
        return cioc;
    }
    
//  *************   Attribute Independent    *****************************************
	boolean independent;
	public void set_independent(boolean independent) {
        this.independent = independent;
    }
    public boolean get_independent() {
        return independent;
    }
    
//  *************   Attribute Status    *****************************************
	String status;
	public void set_status(String status) {
        this.status = status;
    }
    public String get_status() {
        return status;
    }
    
//  *************   Attribute UnMember    *****************************************
	boolean unMember;
	public void set_unMember(boolean unMember) {
        this.unMember = unMember;
    }
    public boolean get_unMember() {
        return unMember;
    }
    
//  *************   Attribute Currencies    *****************************************
    Currencies currencies;
	public void set_currencies(Currencies currencies) {
        this.currencies = currencies;
    }
    public Currencies get_currencies() {
        return currencies;
    }
    //  *************   Class Currencies    *****************************************
    public static class Currencies{
    	//  *************   Attribute GTQ    *****************************************
    	private GTQ GTQ;
    	public void set_GTQ(GTQ GTQ) {
            this.GTQ = GTQ;
        }
        public GTQ get_GTQ() {
            return GTQ;
        }
        //  *************   Class GTQ    *****************************************
    	public static class GTQ{
    		//  *************   Attribute GTQ Name    *****************************************
    		private String name;
    		public void set_GTQname(String name) {
    	        this.name = name;
    	    }
    	    public String get_GTQname() {
    	        return name;
    	    }
    	    //  *************   Attribute GTQ Symbol    *****************************************
    		private char symbol;
    		public void set_GTQsymbol(char symbol) {
    	        this.symbol = symbol;
    	    }
    	    public char get_GTQsymbol() {
    	        return symbol;
    	    }
    	}
    }
    
//  *************   Attribute idd    *****************************************
	Idd idd;
	public void set_idd(Idd idd) {
        this.idd = idd;
    }
    public Idd get_idd() {
        return idd;
    }
    //  *************   Class idd    *****************************************
    public static class Idd{
    	//  *************   Attribute root    *****************************************
    	String root;
    	public void set_root(String root) {
            this.root = root;
        }
        public String get_root() {
            return root;
        }
    	//  *************   Attribute Suffixes    *****************************************
    	List<Integer> suffixes = new ArrayList<>();
    	public void set_suffixes(List<Integer> suffixes) {
            this.suffixes = suffixes;
        }
        public List<Integer> get_suffixes() {
            return suffixes;
        }
    }
    
//  *************   Attribute Capital    *****************************************
	List<String> capital = new ArrayList<>();
	public void set_capital(List<String> capital) {
        this.capital = capital;
    }
    public List<String> get_capital() {
        return capital;
    }
    
//  *************   Attribute AltSpellings    *****************************************
	List<String> altSpellings = new ArrayList<>();
	public void set_altSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }
    public List<String> get_altSpellings() {
        return altSpellings;
    }
    
//  *************   Attribute Region    *****************************************
	String region;
	public void set_region(String region) {
        this.region = region;
    }
    public String get_region() {
        return region;
    }
    
//  *************   Attribute Subregion    *****************************************
	String subregion;
	public void set_subregion(String subregion) {
        this.subregion = subregion;
    }
    public String get_subregion() {
        return subregion;
    }
    
//  *************   Attribute Languages    *****************************************
	Languages languages;
	public void set_languages(Languages languages) {
        this.languages = languages;
    }
    public Languages get_languages() {
        return languages;
    }
    //  *************   Class Languages    *****************************************
    public static class Languages{
    	//  *************   Attribute spa    *****************************************
    	String spa;
    	public void set_language_spa(String spa) {
    		this.spa = spa;
    	}
    	public String get_language_spa() {
    		return spa;
    	}
    }
    
//  *************   Attribute Translations    *****************************************
    Translation translations;
	public void set_translations(Translation translations) {
        this.translations = translations;
    }
    public Translation get_translations() {
        return translations;
    }
    
//  *************   Attribute Latlng    *****************************************
	List<Float> latlng = new ArrayList<>();
	public void set_latlng(List<Float> latlng) {
        this.latlng = latlng;
    }
    public List<Float> get_latlng() {
        return latlng;
    }
    
//  *************   Attribute Landlocked    *****************************************
	boolean landlocked;
	public void set_landlocked(boolean landlocked) {
        this.landlocked = landlocked;
    }
    public boolean get_landlocked() {
        return landlocked;
    }
    
//  *************   Attribute Borders    *****************************************
	List<String> borders = new ArrayList<>();
	public void set_borders(List<String> borders) {
        this.borders = borders;
    }
    public List<String> get_borders() {
        return borders;
    }
    
//  *************   Attribute Area    *****************************************
	Float area;
	public void set_area(Float area) {
        this.area = area;
    }
    public Float get_area() {
        return area;
    }
    
//  *************   Attribute Demonyms    *****************************************
    Demonyms demonyms;
	public void set_demonyms(Demonyms demonyms) {
        this.demonyms = demonyms;
    }
    public Demonyms get_demonyms() {
        return demonyms;
    }
    //  *************   Class Demonyms    *****************************************
    public static class Demonyms{
    	//  *************   Attribute eng    *****************************************
        Eng eng;
    	public void set_eng(Eng eng) {
            this.eng = eng;
        }
        public Eng get_eng() {
            return eng;
        }
        public static class Eng{
        	String f;
        	public void set_f(String f) {
                this.f = f;
            }
            public String get_f() {
                return f;
            }
            
            String m;
        	public void set_m(String m) {
                this.m = m;
            }
            public String get_m() {
                return m;
            }
        }
        //  *************   Attribute fra    *****************************************
        Fra fra;
    	public void set_fra(Fra fra) {
            this.fra = fra;
        }
        public Fra get_fra() {
            return fra;
        }
        public static class Fra{
        	String f;
        	public void set_f(String f) {
                this.f = f;
            }
            public String get_f() {
                return f;
            }
            
            String m;
        	public void set_m(String m) {
                this.m = m;
            }
            public String get_m() {
                return m;
            }
        }
    }
    
    
//  *************   Attribute Flag    *****************************************
	String flag;
	public void set_flag(String flag) {
        this.flag = flag;
    }
    public String get_flag() {
        return flag;
    }
    
//  *************   Attribute Maps    *****************************************
	Map maps;
	public void set_maps(Map maps) {
        this.maps = maps;
    }
    public Map get_maps() {
        return maps;
    }
    //  *************   Class Map    *****************************************
    public static class Map{
    	//  *************   Attribute googleMaps    *****************************************
    	String googleMaps;
    	public void set_googleMaps(String googleMaps) {
            this.googleMaps = googleMaps;
        }
        public String get_googleMaps() {
            return googleMaps;
        }
    	//  *************   Attribute openStreetMaps    *****************************************
        String openStreetMaps;
    	public void set_openStreetMaps(String openStreetMaps) {
            this.openStreetMaps = openStreetMaps;
        }
        public String get_openStreetMaps() {
            return openStreetMaps;
        }
    }
    
//  *************   Attribute Population    *****************************************
	int population;
	public void set_population(int population) {
        this.population = population;
    }
    public int get_population() {
        return population;
    }
    
//  *************   Attribute Population    *****************************************
    Gini gini;
	public void set_gini(Gini gini) {
        this.gini = gini;
    }
    public Gini get_gini() {
        return gini;
    }
    //  *************   Class Gini    *****************************************
    public static class Gini{
    	HashMap<Integer, Double> values = new HashMap<>();
        
        public void setValue(int year, double value) {
            values.put(year, value);
        }
        
        public Double getValue(int year) {
            return values.get(year);
        }
    }
    
//  *************   Attribute Fifa    *****************************************
	String fifa;
	public void set_fifa(String fifa) {
        this.fifa = fifa;
    }
    public String get_fifa() {
        return fifa;
    }
    
//  *************   Attribute Car    *****************************************
	Car car;
	public void set_car(Car car) {
        this.car = car;
    }
    public Car get_car() {
        return car;
    }
    //  *************   Class Car    *****************************************
    public static class Car{
    	//  *************   Attribute sings    *****************************************
    	List<String> sings = new ArrayList<>();
    	public void set_car_sings(List<String> sings) {
            this.sings = sings;
        }
        public List<String> get_car_sings() {
            return sings;
        }
        
        //  *************   Attribute side    *****************************************
    	String side;
    	public void set_car_side(String side) {
            this.side = side;
        }
        public String get_car_side() {
            return side;
        }
    }
    
//  *************   Attribute Timezones    *****************************************
	List<String> timezones = new ArrayList<>();
	public void set_timezones(List<String> timezones) {
        this.timezones = timezones;
    }
    public List<String> get_timezones() {
        return timezones;
    }
    
//  *************   Attribute Continents    *****************************************
	List<String> continents = new ArrayList<>();
	public void set_continents(List<String> continents) {
        this.continents = continents;
    }
    public List<String> get_continents() {
        return continents;
    }
    
//  *************   Attribute Flags    *****************************************
	Flags flags;
	public void set_flags(Flags flags) {
        this.flags = flags;
    }
    public Flags get_flags() {
        return flags;
    }
    //  *************   Class Flags    *****************************************
    public static class Flags{
    //  *************   Attribute png    *****************************************
    	String png;
    	public void set_Flags_png(String png) {
            this.png = png;
        }
        public String get_Flags_png() {
            return png;
        }
    	//  *************   Attribute svg    *****************************************
        String svg;
    	public void set_Flag_svg(String svg) {
            this.svg = svg;
        }
        public String get_Flag_svg() {
            return svg;
        }
        //  *************   Attribute svg    *****************************************
        String alt;
    	public void set_Flag_alt(String alt) {
            this.alt = alt;
        }
        public String get_Flag_alt() {
            return alt;
        }
    }
    
//  *************   Attribute CoatOfArms    *****************************************
	CoatOfArm coatOfArms;
	public void set_coatOfArms(CoatOfArm coatOfArms) {
        this.coatOfArms = coatOfArms;
    }
    public CoatOfArm get_coatOfArms() {
        return coatOfArms;
    }
    //  *************   Class CoatOfArm    *****************************************
    public static class CoatOfArm{
    	//  *************   Attribute png    *****************************************
    	String png;
    	public void set_CoatOfArm_png(String png) {
            this.png = png;
        }
        public String get_CoatOfArm_png() {
            return png;
        }
    	//  *************   Attribute svg    *****************************************
        String svg;
    	public void set_CoatOfArm_svg(String svg) {
            this.svg = svg;
        }
        public String get_CoatOfArm_svg() {
            return svg;
        }
    }
    
//  *************   Attribute StartOfWeek    *****************************************
	String startOfWeek;
	public void set_startOfWeek(String startOfWeek) {
        this.startOfWeek = startOfWeek;
    }
    public String get_startOfWeek() {
        return startOfWeek;
    }
    
//  *************   Attribute CapitalInfo    *****************************************
	List<CapitalInfo> capitalInfo = new ArrayList<>();
	public void set_capitalInfo(List<CapitalInfo> capitalInfo) {
        this.capitalInfo = capitalInfo;
    }
    public List<CapitalInfo> get_capitalInfo() {
        return capitalInfo;
    }
    //  *************   Class CapitalInfo    *****************************************
    public static class CapitalInfo{
    	//  *************   Attribute Latlng    *****************************************
    	List<String> latlng;
    	public void set_CapitalInfo_latlng(List<String> latlng) {
            this.latlng = latlng;
        }
        public List<String> get_CapitalInfo_latlng() {
            return latlng;
        }
    }
    
//  *************   Attribute PostalCode    *****************************************
    PostalCode postalCode;
	public void set_postalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }
    public PostalCode get_postalCode() {
        return postalCode;
    }
    //  *************   Class PostalCode    *****************************************
    public static class PostalCode{
    	//  *************   Attribute Format    *****************************************
    	String format;
    	public void set_format(String format) {
            this.format = format;
        }
        public String get_format() {
            return format;
        }
    	//  *************   Attribute Regex    *****************************************
        String regex;
    	public void set_regex(String regex) {
            this.regex = regex;
        }
        public String get_regex() {
            return regex;
        }
    }
	
}
