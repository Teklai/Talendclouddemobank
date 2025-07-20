package routines;
import java.util.ArrayList;
import java.util.List;



public class global_vars
{
	
	public static List<String> getTafseerAutorOriginal(final String strLang)
	{

		final List<tafseerSource> mytafseer   = global_vars.getTafseerList();
		final List<String>        tafseerLang = new ArrayList<>();

		if(strLang != null && global_vars.getLanguages().contains(strLang))
		{
			for(final tafseerSource tafseer : mytafseer)
			{

				if(strLang.equalsIgnoreCase(tafseer.getLanguage()))
				{
					tafseerLang.add(tafseer.getAutor_original());
					// System.out.println(tafseer.getAutor_original());
					
				}
			}
			return tafseerLang;
		}
		else
		{
			return null;
		}

	}

	public static String getSuraName(final String strSura_num)
	{
		String         strSura_nam = "";
		final String[] arrStrSurat = global_vars.getSurat(null);
		
		try
		{
			final int i = Integer.parseInt(strSura_num);
			strSura_nam = arrStrSurat[i];

			System.out.println(arrStrSurat[i]);
		}
		catch(final Exception ex)
		{
			strSura_nam = strSura_num;
			System.out.println(ex);
		}
		return strSura_nam;
		
	}

	public static String[] getSurat(final String strLang)
	{
		if(strLang == null || "arabic".equalsIgnoreCase(strLang))
		{
			final String[] sura_arabic_name = {"", "الفاتحة", "البقرة", "آل عمران", "النساء", "المائدة", "الأنعام",
				"الأعراف", "الأنفال", "التوبة", "يونس", "هود", "يوسف", "الرعد", "إبراهيم", "الحجر", "النحل", "الإسراء",
				"الكهف", "مريم", "طه", "الأنبياء", "الحج", "المؤمنون", "النور", "الفرقان", "الشعراء", "النمل", "القصص",
				"العنكبوت", "الروم", "لقمان", "السجدة", "الأحزاب", "سبأ", "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر",
				"فصلت", "الشورى", "الزخرف", "الدخان", "الجاثية", "الأحقاف", "محمد", "الفتح", "الحجرات", "ق", "الذاريات",
				"الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة", "الحشر", "الممتحنة", "الصف",
				"الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج", "نوح",
				"الجن", "المزمل", "المدثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات", "عبس", "التكوير",
				"الانفطار", "المطففين", "الانشقاق", "البروج", "الطارق", "الأعلى", "الغاشية", "الفجر", "البلد", "الشمس",
				"الليل", "الضحى", "الشرح", "التين", "العلق", "القدر", "البينة", "الزلزلة", "العاديات", "القارعة",
				"التكاثر", "العصر", "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكافرون", "النصر", "المسد",
				"الإخلاص", "الفلق", "الناس"};
			return sura_arabic_name;
		}
		else
		{
			final String[] sura_latin_name = {
				"", "Al-Fatiha", "Al-Baqarah", "Al-i-'Imran", "An-Nisaa", "Al-Maidah", "Al-An'am", "Al-A'raf",
				"Al-Anfal",
				"At-Touba", "Yunus", "Hud", "Yusuf", "Ar-Ra'd", "Ibrahim", "Al-Hijr", "An-Nahl", "Al-Israa", "Al-kahf",
				"Maryam", "Ta-Ha", "Al-Anbiyaa", "Al-Hajj", "Al-Muminun", "An-Nur", "Al-Furqan", "Ash-Shu'araa",
				"An-Naml", "Al-Qasas", "Al-'Ankabut", "Ar-Rum", "Luqman", "As-Sajda", "Al-Ahzab", "Saba", "Fatir",
				"Ya-Sin", "As-Saffat", "Sad", "Az-Zumar", "Gafir", "Fussilat", "Ash-shura", "Az-Zukhruf", "Ad-Dukhan",
				"Al-Jathiya", "Al-Ahqaf", "Muhammad", "Al-fat-h", "Al-Hujurat", "Qaf", "Az-Zariyat", "At-Tur",
				"An-Najm", "Al-Qamar", "Ar-Rahman", "Al-Waqi'a", "Al-Hadid", "Al-Mujadila", "Al-Hashr", "Al-Mumtahana",
				"As-Saff", "Al-Jumu'a", "Al-Munafiqun", "At-Tagabun", "At-Talaq", "At-Tahrim", "Al-Mulk", "Al-Qalam",
				"Al-Haqqa", "Al-Ma'arij", "Nuh", "Al-Jinn", "Al-Muzzammil", "Al-Muddaththir", "Al-Qiyamat", "Al-Insan",
				"Al-Mursalat", "An-Nabaa", "An-Nazi'at", "'Abasa", "At-Takwir", "Al-Infitar", "Al-Mutaffifeen",
				"Al-Inshiqaq", "Al-Buruj", "At-Tariq", "Al-A'la", "Al-Gashiya", "Al-Fajr", "Al-Balad", "Ash-Shams",
				"Al-Lail", "Ad-Dhuha", "Al-Sharh", "At-Tin", "Al-'Alaq", "Al-Qadr", "Al-Baiyina", "Al-Zalzalah",
				"Al-'Adiyat", "Al-Qari'a", "At-Takathur", "Al-'Asr", "Al-Humaza", "al-Fil", "Quraish", "Al-Ma'un",
				"Al-Kauthar", "Al-Kafirun", "An-Nasr", "Al-Masad", "Al-Ikhlas", "Al-Falaq", "An-Nas"
			};
			return sura_latin_name;
		}
	}

	public static List<String> getLanguages()
	{
		final List<String> language = new ArrayList<>();
		language.add("Albanian");
		language.add("Amazigh");
		language.add("Arabic");
		language.add("Amharic");
		language.add("Azerbaijani");
		language.add("Bengali");
		language.add("Bosnian");
		language.add("Bulgarian");
		language.add("Chinese");
		language.add("Czech");
		language.add("Divehi");
		language.add("Dutch");
		language.add("English");
		language.add("French");
		language.add("German");
		language.add("Hausa");
		language.add("Hindi");
		language.add("Indonesian");
		language.add("Italian");
		language.add("Japanese");
		language.add("Korean");
		language.add("Kurdish");
		language.add("Malay");
		language.add("Malayalam");
		language.add("Norwegian");
		language.add("Pashto");
		language.add("Persian");
		language.add("Polish");
		language.add("Portuguese");
		language.add("Romanian");
		language.add("Russian");
		language.add("Sindhi");
		language.add("Somali");
		language.add("Spanish");
		language.add("Swahili");
		language.add("Swedish");
		language.add("Tajik");
		language.add("Tamil");
		language.add("Tatar");
		language.add("Thai");
		language.add("Turkish");
		language.add("Urdu");
		language.add("Uyghur");
		language.add("Uzbek");

		return language;
	}

	public static class tafseerSource
	{
		private String id;
		private String language;
		private String autor_original;
		private String autor_latin;
		private String source;
		private String table;
		private String align;

		public tafseerSource()
		{
			super();
			
		}
		
		public tafseerSource(
			final String id,
			final String language,
			final String autor_original,
			final String autor_latin,
			final String source,
			final String table,
			final String align)
		{
			this.setId(id);
			this.setLanguage(language);
			this.setAutor_original(autor_original);
			this.setAutor_latin(autor_latin);
			this.setSource(source);
			this.setTable(table);
			this.setAlign(align);
		}
		
		public String getId()
		{
			return this.id;
		}
		
		public void setId(final String id)
		{
			this.id = id;
		}
		
		public String getLanguage()
		{
			return this.language;
		}
		
		public void setLanguage(final String language)
		{
			this.language = language;
		}

		public String getAutor_original()
		{
			return this.autor_original;
		}
		
		public void setAutor_original(final String autor_original)
		{
			this.autor_original = autor_original;
		}
		
		public String getAutor_latin()
		{
			return this.autor_latin;
		}
		
		public void setAutor_latin(final String autor_latin)
		{
			this.autor_latin = autor_latin;
		}
		
		public String getSource()
		{
			return this.source;
		}
		
		public void setSource(final String source)
		{
			this.source = source;
		}
		
		public String getTable()
		{
			return this.table;
		}
		
		public void setTable(final String table)
		{
			this.table = table;
		}
		
		public String getAlign()
		{
			return this.align;
		}
		
		public void setAlign(final String align)
		{
			this.align = align;
		}
		
		// getters/setters, custom hashcode/equals
	}
	
	public static List<tafseerSource> getTafseerList()
	{
		final List<tafseerSource> tafseer = new ArrayList<>();

		tafseer
			.add(new tafseerSource("001", "Albanian", "Efendi Nahi", "Hasan Efendi Nahi", "tanzil.net",
				"albanian__nahi", "left"));
		tafseer
			.add(
				new tafseerSource("002", "Albanian", "Feti Mehdiu", "Feti Mehdiu", "tanzil.net", "albanian__mehdiu",
					"left"));
		tafseer.add(new tafseerSource("003", "Albanian", "Sherif Ahmeti", "Sherif Ahmeti", "tanzil.net",
			"albanian__ahmeti", "left"));
		tafseer.add(new tafseerSource("004", "Amazigh", "At Mensur", "Ramdane At Mansour", "tanzil.net",
			"amazigh__at_mensur", "left"));
		tafseer.add(new tafseerSource("005", "Arabic", "تفسير الجلالين",
			"Jalal ad-Din al-Mahalli and Jalal ad-Din as-Suyuti", "tanzil.net", "arabic__jalalayn", "right"));
		tafseer
			.add(new tafseerSource("006", "Arabic", "تفسير المیسر", "King Fahad Quran Complex", "tanzil.net",
				"arabic__moyassar", "right"));
		tafseer
			.add(new tafseerSource("007", "Amharic", "ሳዲቅ & ሳኒ ሐቢብ", "Muhammed Sadiq and Muhammed Sani Habib",
				"tanzil.net", "amharic__sadiq_and_habib", "left"));
		tafseer.add(new tafseerSource("008", "Azerbaijani", "Məmmədəliyev & Bünyadov",
			"Vasim Mammadaliyev and Ziya Bunyadov", "tanzil.net", "azerbaijani__memmedeliyev_and_buenyadov",
			"left"));
		tafseer.add(new tafseerSource("009", "Azerbaijani", "Musayev", "Alikhan Musayev", "tanzil.net",
			"azerbaijani__vasim_and_ziya", "left"));
		tafseer.add(
			new tafseerSource("010", "Bengali", "জহুরুল হক", "Zohurul Hoque", "tanzil.net", "bengali__hoque",
				"left"));
		tafseer
			.add(new tafseerSource("011", "Bengali", "মুহিউদ্দীন খান", "Muhiuddin Khan", "tanzil.net",
				"bengali__muhiuddin_khan", "left"));
		tafseer.add(
			new tafseerSource("012", "Bosnian", "Korkut", "Besim Korkut", "tanzil.net", "bosnian__korkut", "left"));
		tafseer
			.add(new tafseerSource("013", "Bosnian", "Mlivo", "Mustafa Mlivo", "tanzil.net", "bosnian__mlivo",
				"left"));
		tafseer
			.add(new tafseerSource("014", "Bulgarian", "Теофанов", "Tzvetan Theophanov", "tanzil.net",
				"bulgarian__theophanov", "left"));
		tafseer
			.add(new tafseerSource("015", "Chinese", "Ma Jian", "Ma Jian", "tanzil.net", "chinese__ma_jian",
				"left"));
		tafseer
			.add(new tafseerSource("016", "Chinese", "Ma Jian (Traditional))", "Ma Jian", "tanzil.net",
				"chinese__traditional", "left"));
		tafseer
			.add(new tafseerSource("017", "Czech", "Hrbek", "Preklad I. Hrbek", "tanzil.net", "czech__hrbek",
				"left"));
		tafseer
			.add(new tafseerSource("018", "Czech", "Nykl", "A. R. Nykl", "tanzil.net", "czech__nykl", "left"));
		tafseer
			.add(new tafseerSource("019", "Divehi", "ދިވެހި", "Office of the President of Maldives", "tanzil.net",
				"divehi__maldives", "left"));
		tafseer
			.add(new tafseerSource("020", "Dutch", "Keyzer", "Salomo Keyzer", "tanzil.net", "dutch__keyzer",
				"left"));
		tafseer.add(
			new tafseerSource("021", "Dutch", "Leemhuis", "Fred Leemhuis", "tanzil.net", "dutch__leemhuis",
				"left"));
		tafseer.add(
			new tafseerSource("022", "Dutch", "Siregar", "Sofian S. Siregar", "tanzil.net", "dutch__siregar",
				"left"));
		tafseer.add(
			new tafseerSource("023", "English", "Ahmed Ali", "Ahmed Ali", "tanzil.net", "english__ahmed_ali",
				"left"));
		tafseer
			.add(new tafseerSource("024", "English", "Ahmed Raza Khan", "Ahmed Raza Khan", "tanzil.net",
				"english__raza_khan", "left"));
		tafseer.add(
			new tafseerSource("025", "English", "Arberry", "A. J. Arberry", "tanzil.net", "english__arberry",
				"left"));
		tafseer
			.add(new tafseerSource("026", "English", "Daryabadi", "Abdul Majid Daryabadi", "tanzil.net",
				"english__daryabadi", "left"));
		tafseer.add(new tafseerSource("027", "English", "Hilali & Khan",
			"Muhammad Taqi-ud-Din al-Hilali and Muhammad Muhsin Khan", "tanzil.net", "english__hilali_and_khan",
			"left"));
		tafseer
			.add(new tafseerSource("028", "English", "Itani", "Talal Itani", "tanzil.net", "english__itani",
				"left"));
		tafseer
			.add(
				new tafseerSource("029", "English", "Maududi", "Abul Ala Maududi", "tanzil.net", "english__maududi",
					"left"));
		tafseer
			.add(new tafseerSource("030", "English", "Mubarakpuri", "Safi-ur-Rahman al-Mubarakpuri", "tanzil.net",
				"english__mubarakpuri", "left"));
		tafseer
			.add(new tafseerSource("031", "English", "Pickthall", "Mohammed Marmaduke William Pickthall",
				"tanzil.net", "english__pickthall", "left"));
		tafseer.add(
			new tafseerSource("032", "English", "Qarai", "Ali Quli Qarai", "tanzil.net", "english__qarai", "left"));
		tafseer.add(new tafseerSource("033", "English", "Qaribullah & Darwish",
			"Hasan al-Fatih Qaribullah and Ahmad Darwish", "tanzil.net", "english__qaribullah_and_darwish",
			"left"));
		tafseer
			.add(new tafseerSource("034", "English", "Saheeh International", "Saheeh International", "tanzil.net",
				"english__saheeh_international", "left"));
		tafseer.add(
			new tafseerSource("035", "English", "Sarwar", "Muhammad Sarwar", "tanzil.net", "english__sarwar",
				"left"));
		tafseer.add(new tafseerSource("036", "English", "Shakir", "Mohammad Habib Shakir", "tanzil.net",
			"english__shakir", "left"));
		tafseer
			.add(new tafseerSource("037", "English", "Transliteration", "English Transliteration", "tanzil.net",
				"english__transliteration", "left"));
		tafseer
			.add(new tafseerSource("038", "English", "Wahiduddin Khan", "Wahiduddin Khan", "tanzil.net",
				"english__wahiduddin_khan", "left"));
		tafseer.add(new tafseerSource("039", "English", "Yusuf Ali", "Abdullah Yusuf Ali", "tanzil.net",
			"english__yusuf_ali", "left"));
		tafseer
			.add(new tafseerSource("040", "French", "Hamidullah", "Muhammad Hamidullah", "tanzil.net",
				"french__hamidullah", "left"));
		tafseer
			.add(new tafseerSource("041", "German", "Abu Rida", "Abu Rida Muhammad ibn Ahmad ibn Rassoul",
				"tanzil.net", "german__abu_rida", "left"));
		tafseer
			.add(new tafseerSource("042", "German", "Bubenheim & Elyas", "A. S. F. Bubenheim and N. Elyas",
				"tanzil.net", "german__bubenheim-and-elyas", "left"));
		tafseer
			.add(new tafseerSource("043", "German", "Khoury", "Adel Theodor Khoury", "tanzil.net", "german__khoury",
				"left"));
		tafseer
			.add(new tafseerSource("044", "German", "Zaidan", "Amir Zaidan", "tanzil.net", "german__zaidan",
				"left"));
		tafseer.add(
			new tafseerSource("045", "Hausa", "Gumi", "Abubakar Mahmoud Gumi", "tanzil.net", "hausa__gumi",
				"left"));
		tafseer
			.add(new tafseerSource("046", "Hindi", "फ़ारूक़ ख़ान & अहमद", "Muhammad Farooq Khan and Muhammad Ahmed",
				"tanzil.net", "hindi__farooq_and_ahmed", "left"));
		tafseer
			.add(new tafseerSource("047", "Hindi", "फ़ारूक़ ख़ान & नदवी", "Suhel Farooq Khan and Saifur Rahman Nadwi",
				"tanzil.net", "hindi__farooq_and_saifur", "left"));
		tafseer.add(new tafseerSource("048", "Indonesian", "Bahasa Indonesia",
			"Indonesian Ministry of Religious Affairs", "tanzil.net", "indonesian__bahasa_indonesia", "left"));
		tafseer
			.add(new tafseerSource("049", "Indonesian", "Quraish Shihab", "Muhammad Quraish Shihab et al.",
				"tanzil.net", "indonesian__quraish_shihab", "left"));
		tafseer.add(new tafseerSource("050", "Indonesian", "Tafsir Jalalayn",
			"Jalal ad-Din al-Mahalli and Jalal ad-Din as-Suyuti", "tanzil.net", "indonesian__jalalayn", "left"));
		tafseer
			.add(new tafseerSource("051", "Italian", "Piccardo", "Hamza Roberto Piccardo", "tanzil.net",
				"italian__piccardo", "left"));
		tafseer.add(
			new tafseerSource("052", "Japanese", "Japanese", "Unknown", "tanzil.net", "japanese__japanese",
				"left"));
		tafseer
			.add(new tafseerSource("053", "Korean", "Korean", "Unknown", "tanzil.net", "korean__korean", "left"));
		tafseer
			.add(new tafseerSource("054", "Kurdish", "ته‌فسیری ئاسان", "Burhan Muhammad-Amin", "tanzil.net",
				"kurdish__burhan", "left"));
		tafseer
			.add(new tafseerSource("055", "Malay", "Basmeih", "Abdullah Muhammad Basmeih", "tanzil.net",
				"malay__basmeih", "left"));
		tafseer.add(new tafseerSource("056", "Malayalam", "അബ്ദുല്‍ ഹമീദ് & പറപ്പൂര്‍",
			"Cheriyamundam Abdul Hameed and Kunhi Mohammed Parappoor", "tanzil.net",
			"malayalam__cheriymundam_and_parappoor", "left"));
		tafseer.add(new tafseerSource("057", "Malayalam", "കാരകുന്ന് & എളയാവൂര്",
			"Muhammad Karakunnu and Vanidas Elayavoor", "tanzil.net", "malayalam__karakunnu_and_elayavoor",
			"left"));
		tafseer.add(new tafseerSource("058", "Norwegian", "Einar Berg", "Einar Berg", "tanzil.net",
			"norwegian__einar_berg", "left"));
		tafseer.add(new tafseerSource("059", "Pashto", "عبدالولي", "Abdulwali Khan", "tanzil.net",
			"pashto__abdulwali_khan", "right"));
		tafseer.add(new tafseerSource("060", "Persian", "انصاریان", "Hussain Ansarian", "tanzil.net",
			"persian__ansarian", "right"));
		tafseer
			.add(new tafseerSource("061", "Persian", "آیتی", "AbdolMohammad Ayati", "tanzil.net", "persian__ayati",
				"right"));
		tafseer
			.add(new tafseerSource("062", "Persian", "بهرام پور", "Abolfazl Bahrampour", "tanzil.net",
				"persian__bahrampour", "right"));
		tafseer
			.add(new tafseerSource("063", "Persian", "قرائتی", "Mohsen Gharaati", "tanzil.net", "persian__gharaati",
				"right"));
		tafseer
			.add(new tafseerSource("064", "Persian", "الهی قمشه‌ای", "Mahdi Elahi Ghomshei", "tanzil.net",
				"persian__ghomshei", "right"));
		tafseer.add(new tafseerSource("065", "Persian", "خرمدل", "Mostafa Khorramdel", "tanzil.net",
			"persian__khorramdel", "right"));
		tafseer
			.add(new tafseerSource("066", "Persian", "خرمشاهی", "Baha'oddin Khorramshahi", "tanzil.net",
				"persian__khorramshahi", "right"));
		tafseer
			.add(new tafseerSource("067", "Persian", "صادقی تهرانی", "Mohammad Sadeqi Tehrani", "tanzil.net",
				"persian__tehrani", "right"));
		tafseer
			.add(new tafseerSource("068", "Persian", "فولادوند", "Mohammad Mahdi Fooladvand", "tanzil.net",
				"persian__fooladvand", "right"));
		tafseer
			.add(new tafseerSource("069", "Persian", "مجتبوی", "Sayyed Jalaloddin Mojtabavi", "tanzil.net",
				"persian__mojtabavi", "right"));
		tafseer.add(new tafseerSource("070", "Persian", "معزی", "Mohammad Kazem Moezzi", "tanzil.net",
			"persian__moezzi", "right"));
		tafseer
			.add(new tafseerSource("071", "Persian", "مکارم شیرازی", "Naser Makarem Shirazi", "tanzil.net",
				"persian__shirazi", "right"));
		tafseer
			.add(new tafseerSource("072", "Polish", "Bielawskiego", "Józefa Bielawskiego", "tanzil.net",
				"polish__bielawskiego", "left"));
		tafseer.add(new tafseerSource("073", "Portuguese", "El-Hayek", "Samir El-Hayek", "tanzil.net",
			"portuguese__el_hayek", "left"));
		tafseer
			.add(
				new tafseerSource("074", "Romanian", "Grigore", "George Grigore", "tanzil.net", "romanian__grigore",
					"left"));
		tafseer.add(
			new tafseerSource("075", "Russian", "Абу Адель", "Abu Adel", "tanzil.net", "russian__abu_adel",
				"left"));
		tafseer
			.add(new tafseerSource("076", "Russian", "Аль-Мунтахаб", "Ministry of Awqaf, Egypt", "tanzil.net",
				"russian__egypt_awqaf", "left"));
		tafseer
			.add(new tafseerSource("077", "Russian", "Крачковский", "Ignaty Yulianovich Krachkovsky", "tanzil.net",
				"russian__yulianovich", "left"));
		tafseer.add(
			new tafseerSource("078", "Russian", "Кулиев", "Elmir Kuliev", "tanzil.net", "russian__kuliev", "left"));
		tafseer.add(new tafseerSource("079", "Russian", "Кулиев & ас-Саади",
			"Elmir Kuliev (with Abd ar-Rahman as-Saadi's commentaries))", "tanzil.net",
			"russian__kuliev_with_as_saadi",
			"left"));
		tafseer
			.add(new tafseerSource("080", "Russian", "Османов", "Magomed-Nuri Osmanovich Osmanov", "tanzil.net",
				"russian__magomed_nuri", "left"));
		tafseer
			.add(new tafseerSource("081", "Russian", "Порохова", "V. Porokhova", "tanzil.net", "russian__porokhova",
				"left"));
		tafseer
			.add(new tafseerSource("082", "Russian", "Саблуков", "Gordy Semyonovich Sablukov", "tanzil.net",
				"russian__semyonovich", "left"));
		tafseer
			.add(new tafseerSource("083", "Sindhi", "امروٽي", "Taj Mehmood Amroti", "tanzil.net", "sindhi__amroti",
				"right"));
		tafseer
			.add(new tafseerSource("084", "Somali", "Abduh", "Mahmud Muhammad Abduh", "tanzil.net", "somali__abduh",
				"left"));
		tafseer.add(new tafseerSource("085", "Spanish", "Bornez", "Raúl González Bórnez", "tanzil.net",
			"spanish__bornez", "left"));
		tafseer.add(
			new tafseerSource("086", "Spanish", "Cortes", "Julio Cortes", "tanzil.net", "spanish__cortes", "left"));
		tafseer.add(new tafseerSource("087", "Spanish", "Garcia", "Muhammad Isa García", "tanzil.net",
			"spanish__garcia", "left"));
		tafseer
			.add(new tafseerSource("088", "Swahili", "Al-Barwani", "Ali Muhsin Al-Barwani", "tanzil.net",
				"swahili__al_barwani", "left"));
		tafseer.add(new tafseerSource("089", "Swedish", "Bernström", "Knut Bernström", "tanzil.net",
			"swedish__bernstroem", "left"));
		tafseer.add(
			new tafseerSource("090", "Tajik", "Оятӣ", "AbdolMohammad Ayati", "tanzil.net", "tajik__ayati", "left"));
		tafseer
			.add(new tafseerSource("091", "Tamil", "ஜான் டிரஸ்ட்", "Jan Turst Foundation", "tanzil.net",
				"tamil__jan_turst_foundation", "left"));
		tafseer
			.add(new tafseerSource("092", "Tatar", "Yakub Ibn Nugman", "Yakub Ibn Nugman", "tanzil.net",
				"tatar__ibn_nugman", "left"));
		tafseer
			.add(new tafseerSource("093", "Thai", "ภาษาไทย", "King Fahad Quran Complex", "tanzil.net",
				"thai__quran_complex", "left"));
		tafseer
			.add(new tafseerSource("094", "Turkish", "Abdulbakî Gölpınarlı", "Abdulbaki Golpinarli", "tanzil.net",
				"turkish__goelpinarli", "left"));
		tafseer.add(
			new tafseerSource("095", "Turkish", "Alİ Bulaç", "Alİ Bulaç", "tanzil.net", "turkish__ali̇_bulac",
				"left"));
		tafseer.add(new tafseerSource("096", "Turkish", "Çeviriyazı", "Muhammet Abay", "tanzil.net",
			"turkish__ceviriyazı", "left"));
		tafseer
			.add(new tafseerSource("097", "Turkish", "Diyanet İşleri", "Diyanet Isleri", "tanzil.net",
				"turkish__diyanet_i̇sleri", "left"));
		tafseer.add(new tafseerSource("098", "Turkish", "Diyanet Vakfı", "Diyanet Vakfi", "tanzil.net",
			"turkish__diyanet_vakfı", "left"));
		tafseer.add(new tafseerSource("099", "Turkish", "Edip Yüksel", "Edip Yüksel", "tanzil.net",
			"turkish__edip_yueksel", "left"));
		tafseer
			.add(new tafseerSource("100", "Turkish", "Elmalılı Hamdi Yazır", "Elmalili Hamdi Yazir", "tanzil.net",
				"turkish__elmalılı_hamdi_yazır", "left"));
		tafseer.add(new tafseerSource("101", "Turkish", "Öztürk", "Yasar Nuri Ozturk", "tanzil.net",
			"turkish__oeztuerk", "left"));
		tafseer.add(new tafseerSource("102", "Turkish", "Suat Yıldırım", "Suat Yildirim", "tanzil.net",
			"turkish__suat_yıldırım", "left"));
		tafseer.add(new tafseerSource("103", "Turkish", "Süleyman Ateş", "Suleyman Ates", "tanzil.net",
			"turkish__sueleyman_ates", "left"));
		tafseer
			.add(new tafseerSource("104", "Urdu", "ابوالاعلی مودودی", "Abul A'ala Maududi", "tanzil.net",
				"urdu__abul_aala_maududi", "right"));
		tafseer.add(new tafseerSource("105", "Urdu", "احمد رضا خان", "Ahmed Raza Khan", "tanzil.net",
			"urdu__ahmed_raza_khan", "right"));
		tafseer
			.add(new tafseerSource("106", "Urdu", "احمد علی", "Ahmed Ali", "tanzil.net", "urdu__ahmed_ali",
				"right"));
		tafseer
			.add(new tafseerSource("107", "Urdu", "جالندہری", "Fateh Muhammad Jalandhry", "tanzil.net",
				"urdu__jalandhry", "right"));
		tafseer.add(new tafseerSource("108", "Urdu", "طاہر القادری", "Tahir ul Qadri", "tanzil.net",
			"urdu__tahir_ul_qadri", "right"));
		tafseer
			.add(new tafseerSource("109", "Urdu", "علامہ جوادی", "Syed Zeeshan Haider Jawadi", "tanzil.net",
				"urdu__jawadi", "right"));
		tafseer
			.add(new tafseerSource("110", "Urdu", "محمد جوناگڑھی", "Muhammad Junagarhi", "tanzil.net",
				"urdu__muhammad_junagarhi", "right"));
		tafseer
			.add(new tafseerSource("111", "Urdu", "محمد حسین نجفی", "Muhammad Hussain Najafi", "tanzil.net",
				"urdu__muhammad_hussain_najafi", "right"));
		tafseer.add(new tafseerSource("112", "Uyghur", "محمد صالح", "Muhammad Saleh", "tanzil.net",
			"uyghur__muhammad_saleh", "right"));
		tafseer
			.add(new tafseerSource("113", "Uzbek", "Мухаммад Содик", "Muhammad Sodik Muhammad Yusuf", "tanzil.net",
				"uzbek__sodik_and-yusuf", "left"));
		tafseer
			.add(new tafseerSource("201", "Arabic", "تفسير إبن كثير", "tafseer ibno katheer", "quran.ksu.edu.sa",
				"ksu_edu_sa_katheer", "right"));
		tafseer
			.add(new tafseerSource("202", "Arabic", "تفسير القرطبي", "tafseer el kortobi", "quran.ksu.edu.sa",
				"ksu_edu_sa_kortobi", "right"));
		tafseer
			.add(new tafseerSource("203", "Arabic", "تفسير الطبري", "tafseer al tabari", "quran.ksu.edu.sa",
				"ksu_edu_sa_tabari", "right"));

		return tafseer;
	}

	public static List<String> fillTollerance()
	{
		final List<String> tollerance = new ArrayList<>();
		
		tollerance.add("maximum");
		tollerance.add("middle");
		tollerance.add("minimum");
		
		return tollerance;
	}
}