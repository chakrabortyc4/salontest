package SpringMy.Maven.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SpringMy.Maven.Utility.CommonUtil;
import SpringMy.Maven.db.dao.CategoryDAO;
import SpringMy.Maven.db.dao.DiscountDataDAO;
import SpringMy.Maven.db.dao.FileDetailDAO;
import SpringMy.Maven.db.dao.PayStatusDAO;
import SpringMy.Maven.db.dao.UsersDAO;
import SpringMy.Maven.db.enities.Category;
import SpringMy.Maven.db.enities.DiscountData;
import SpringMy.Maven.db.enities.File;
import SpringMy.Maven.db.enities.PayStatus;
import SpringMy.Maven.db.enities.Users;
import SpringMy.Maven.model.CategoryCountMap;
import SpringMy.Maven.model.ClubDTO;
import SpringMy.Maven.model.DisplayFileDTO;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.GetPassword;
import SpringMy.Maven.model.Login;
import SpringMy.Maven.model.UserDTO;
import SpringMy.Maven.model.UserStatusDisplayDTO;
import SpringMy.Maven.property.enities.ConfigProperty;

@Service
public class DbServices {

	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private CommonServices commonService;
	@Autowired
	private FileDetailDAO fileDetailDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private PayStatusDAO payStatusDAO;
	@Autowired
	private DiscountDataDAO discountDataDAO;

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	public void setCommonService(CommonServices commonService) {
		this.commonService = commonService;
	}

	public void setFileDetailDAO(FileDetailDAO fileDetailDAO) {
		this.fileDetailDAO = fileDetailDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setPayStatusDAO(PayStatusDAO payStatusDAO) {
		this.payStatusDAO = payStatusDAO;
	}

	public void setDiscountDataDAO(DiscountDataDAO discountDataDAO) {
		this.discountDataDAO = discountDataDAO;
	}

	@Transactional
	public void saveUserData(UserDTO userDTO) throws IOException {
		Users users = new Users();
		users.setUserId(commonUtil.getUserId());
		users.setFirstName(userDTO.getFirstname());
		users.setLastName(userDTO.getLastname());
		users.setGender(userDTO.getGender());
		users.setAddress(userDTO.getAddress());
		users.setCity(userDTO.getCity());
		users.setState(userDTO.getPin());
		users.setCountry(userDTO.getCountry());
		users.setClub(userDTO.getClub());
		users.setHoner(userDTO.getHoner());
		users.setEmail(userDTO.getEmail());
		users.setPassword(userDTO.getPassword());
		users.setCreatedOn(commonUtil.sqlDateTime());
		users.setLastLoggin(commonUtil.sqlDateTime());
		users.setRole("participate");
		usersDAO.persist(users);
		// commonService.sendRegistrationConfirmMail(users);
		System.out.println(users.toString());
	}

	@Transactional
	public List<Users> getUserData(Login login) throws IOException {
		Users users = new Users();
		users.setEmail(login.getUsername());
		users.setPassword(login.getPassword());
		@SuppressWarnings("unchecked")
		List<Users> userData = usersDAO.findByExample(users);
		return userData;

	}

	@Transactional
	public List<String> getListOfAColumn(String columnName) throws IOException {
		List<Users> usersList = usersDAO.findAColumn(columnName);
		List<String> emailList = new ArrayList<String>();
		// System.out.println(usersList.toString());
		if (usersList.size() > 0) {
			for (Users users : usersList) {
				emailList.add(users.getEmail());
			}
		}
		System.out.println(emailList);
		return emailList;
		// return null;

	}

	@Transactional
	public void updateCurrentTimeStamp(List<Users> user) {
		Users users = new Users();
		users.setUserId(user.get(0).getUserId());
		users.setFirstName(user.get(0).getFirstName());
		users.setLastName(user.get(0).getLastName());
		users.setGender(user.get(0).getGender());
		users.setAddress(user.get(0).getAddress());
		users.setCity(user.get(0).getCity());
		users.setState(user.get(0).getState());
		users.setCountry(user.get(0).getCountry());
		users.setClub(user.get(0).getClub());
		users.setHoner(user.get(0).getHoner());
		users.setEmail(user.get(0).getEmail());
		users.setPassword(user.get(0).getPassword());
		users.setCreatedOn(user.get(0).getCreatedOn());
		users.setLastLoggin(commonUtil.sqlDateTime());
		users.setRole(user.get(0).getRole());
		usersDAO.attachDirty(users);

	}

	@Transactional
	public Integer saveFileData(FileDTO fileDTO, UserDTO userDTO) throws IOException {

		File fileDetail = new File();

		Users user = new Users();
		user.setUserId(userDTO.getUserid());

		Category catagory = new Category();
		catagory.setCategoryId(getCategoryIDfromCategoryName(fileDTO));

		fileDetail.setUsers(user);
		fileDetail.setTitel(fileDTO.getTitel());
		fileDetail.setFile(fileDTO.getImages().getBytes());
		// fileDetail.setOriginalFileName(fileDTO.getPositionName()+"_"+fileDTO.getImages().getOriginalFilename());
		fileDetail.setCategoryIndex(fileDTO.getPositionName());
		fileDetail.setOriginalFileName(fileDTO.getImages().getOriginalFilename());
		fileDetail.setUploadTime(commonUtil.sqlDateTime());
		fileDetail.setCategory(catagory);
		// save file
		List<String> listOfTitel = fileDetailDAO.findTitelListOfaCatagory(fileDetail);
		if (listOfTitel.size() == 0) {
			Integer fileid = fileDetailDAO.persist(fileDetail);
			return fileid;
		} else if (listOfTitel.contains(fileDetail.getTitel())) {
			return 0;
		} else {
			Integer fileid = fileDetailDAO.persist(fileDetail);
			return fileid;
		}

	}

	@Transactional
	public String deleteFileData(FileDTO fileDTO) {

		File fileDetail = new File();
		if (fileDTO.getFileId() != null) {
			// fileDetail.setFileId(fileDTO.getFileId());
			fileDetailDAO.deletebyID(fileDTO.getFileId());
			return "Success";
		} else {
			return "Unable to delete.";
		}

	}

	public Integer getCategoryIDfromCategoryName(FileDTO fileDTO) {

		return categoryDAO.getCategoryID(fileDTO.getCatagoryName());
	}

	@Transactional
	public HashMap<String, LinkedList<DisplayFileDTO>> getDisplayFileData(UserDTO userDTO) {
		// List<DisplayFileDTO> listOfDisplayFileDTO = new ArrayList<DisplayFileDTO>();
		List<File> fileDetailList = getUpLoadedFileDetailOfAUser(userDTO);
		HashMap<String, LinkedList<DisplayFileDTO>> hm = new HashMap<>();

		if (fileDetailList.size() > 0) {
			for (File f : fileDetailList) {
				if (hm.containsKey(f.getCategory().getCategoryName())) {
					DisplayFileDTO displayFileDTO = new DisplayFileDTO();
					displayFileDTO.setItemImage(f.getFile());
					displayFileDTO.setTime(f.getUploadTime().toString());
					displayFileDTO.setTitel(f.getTitel());
					displayFileDTO.setFileId(f.getFileId());
					// displayFileDTO.setPosition(f.getOriginalFileName().substring(0,
					// f.getOriginalFileName().indexOf("_")));
					displayFileDTO.setPosition(f.getCategoryIndex());
					LinkedList<DisplayFileDTO> l = hm.get(f.getCategory().getCategoryName());
					l.add(displayFileDTO);
					hm.put(f.getCategory().getCategoryName(), l);
				} else {
					DisplayFileDTO displayFileDTO = new DisplayFileDTO();
					LinkedList<DisplayFileDTO> l = new LinkedList<>();
					displayFileDTO.setItemImage(f.getFile());
					displayFileDTO.setTime(f.getUploadTime().toString());
					displayFileDTO.setTitel(f.getTitel());
					displayFileDTO.setFileId(f.getFileId());
					// displayFileDTO.setPosition(f.getOriginalFileName().substring(0,
					// f.getOriginalFileName().indexOf("_")));
					displayFileDTO.setPosition(f.getCategoryIndex());
					l.add(displayFileDTO);
					hm.put(f.getCategory().getCategoryName(), l);
				}
			}

		}
		// System.out.println(hm);
		return hm;
	}

	@Transactional
	public List<File> getUpLoadedFileDetailOfAUser(UserDTO userDTO) {

		File fileDetail = new File();
		Users user = new Users();
		user.setUserId(userDTO.getUserid());
		fileDetail.setUsers(user);
		List<File> fileDetailList = fileDetailDAO.findByExample(fileDetail);
		return fileDetailList;
	}

	@Transactional
	public void updatePayStatusOfAUser(UserDTO userDTO) {

		Users user = new Users();
		user.setEmail(userDTO.getEmail());
		List<Users> usersList = usersDAO.findByExample(user);
		System.out.println(usersList.get(0).toString());
		if (usersList.size() > 0) {
			File fileDetail = new File();
			fileDetail.setUsers(usersList.get(0));
			List<CategoryCountMap> fileDetailList = fileDetailDAO.getCategoryWiseFileCount(fileDetail);

			PayStatus currentUserPayStatus = payStatusDAO.findByUserId(usersList.get(0));

			if (currentUserPayStatus == null && fileDetailList.size() == 0) { // if entry not found and number of entry
																				// zero, 1st login
				System.out.println("I am on my way ");
				savePayStatusforZeroEntry(usersList.get(0));
			} else if (currentUserPayStatus != null) {
				updatePayStatusforNonZeroEntry(currentUserPayStatus, fileDetailList);
			}

		}

	}

	@Transactional
	public void savePayStatusforZeroEntry(Users user) {

		PayStatus payStatus = new PayStatus();
		payStatus.setAttemptSection(0);
		payStatus.setCouponCodeNumber("");
		List<String> netiveCountryList = Arrays.asList(configProperty.getNetiveCountry().split(","));
		if (netiveCountryList.contains(user.getCountry().toUpperCase()))
			payStatus.setCourencyType(configProperty.getNetiveCurrencyName());
		else
			payStatus.setCourencyType(configProperty.getForeignCurrencyName());
		payStatus.setDiscountAmount(0);
		payStatus.setEntryCreatedTime(commonUtil.sqlDateTime());
		payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
		// payStatus.setPayTime(commonUtil.sqlDateTime());
		payStatus.setPayingStatus(null);
		payStatus.setRecivedAmont(0);
		payStatus.setRecivedCourencyType(null);
		payStatus.setTotalAmount(0);
		payStatus.setTotalEntry(0);
		payStatus.setUsers(user);
		payStatus.setPayingStatus("Being Check");
		System.out.println("payStatus=" + payStatus.toString());
		payStatusDAO.persist(payStatus);

	}

	@Transactional
	public void updatePayStatusforNonZeroEntry(PayStatus payStatus, List<CategoryCountMap> fileDetailList) {
		System.out.println("I am in a writre palce");
		int totalNimberofEntry = 0;
		String[] arry = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		PayStatus updatedpayStatus = new PayStatus();
		updatedpayStatus.setPayId(payStatus.getPayId());

		if (fileDetailList.size() > 0) {
			for (CategoryCountMap c : fileDetailList) {
				totalNimberofEntry = totalNimberofEntry + c.getFile_id();
			}
			updatedpayStatus.setAttemptSection(fileDetailList.size());
			updatedpayStatus.setTotalEntry(totalNimberofEntry);
			if (payStatus.getCourencyType().equals(configProperty.getNetiveCurrencyName()))
				updatedpayStatus.setTotalAmount(Integer
						.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()] + "Netive")));
			else
				updatedpayStatus.setTotalAmount(
						Integer.parseInt(commonUtil.getMethodOutPut("getCategory" + arry[fileDetailList.size()])));

			updatedpayStatus.setDiscountAmount(updatedpayStatus.getTotalAmount());

		} else {
			updatedpayStatus.setAttemptSection(0);
			updatedpayStatus.setTotalEntry(0);
			updatedpayStatus.setTotalAmount(0);
			updatedpayStatus.setDiscountAmount(0);
		}
		updatedpayStatus.setCourencyType(payStatus.getCourencyType());
		updatedpayStatus.setCouponCodeNumber("");
		updatedpayStatus.setEntryCreatedTime(payStatus.getEntryCreatedTime());
		updatedpayStatus.setLastUpdateTime(commonUtil.sqlDateTime());
		updatedpayStatus.setUsers(payStatus.getUsers());
		updatedpayStatus.setPayingStatus("Being Check");
		updatedpayStatus.setRecivedAmont(0);
		updatedpayStatus.setRecivedCourencyType(null);
		System.out.println("updatedpayStatus=" + updatedpayStatus.toString());
		payStatusDAO.attachDirty(updatedpayStatus);
	}

	@Transactional
	public List<UserStatusDisplayDTO> getUserDateForStatusTable() {

		String sql = "SELECT ps.user_id, usr.first_name, usr.last_name, usr.club, usr.country,ps.attempt_section, ps.total_entry, ps.paying_status "
				+ "FROM salontest.pay_status ps, salontest.users usr "
				+ "where ps.user_id=usr.user_id and attempt_section > 0";

		List<UserStatusDisplayDTO> userStatusDisplayDTOList = payStatusDAO.fetchSql(sql);

		return userStatusDisplayDTOList;

	}

	@Transactional
	public int getDiscountPersent(UserDTO userDTO) {

		DiscountData discountData = new DiscountData();
		discountData.setUsers(usersDAO.findById(userDTO.getUserid()));
		@SuppressWarnings("unchecked")
		List<DiscountData> discountDataList = discountDataDAO.findByExample(discountData);
		if (discountDataList.size() > 0) {
			return discountDataList.get(0).getDiscountPersent();
		}

		return 0;

	}

	@Transactional
	public String getPassword(GetPassword getPassword) {
		String password = usersDAO.findPassword(getPassword.getEmail());
		return password;
	}

	@Transactional
	public String createSingleCouponeCode(String userId, String persent, Integer createorUserId, String adminEmail) {

		Users user = new Users();
		user.setUserId(Integer.parseInt(userId));
		List<Users> usersList = usersDAO.findByExample(user);
		if (usersList.size() > 0) {
			List<String> getUserIdofCreatedCouponCode = getUserIdofCreatedCouponCode("usrID");
			if (getUserIdofCreatedCouponCode.size() > 0 && getUserIdofCreatedCouponCode.contains(userId)) {
				return "CouponCode for the user already exist for userId: " + userId;
			} else {
				System.out.println("I am in else");
				String couponcode = commonService.createCouponCode(usersList.get(0).getUserId(),
						usersList.get(0).getFirstName(), usersList.get(0).getLastName());
				DiscountData discountData = new DiscountData();
				discountData.setCouponCode(couponcode);
				discountData.setUsers(usersList.get(0));
				discountData.setDiscountPersent(Integer.parseInt(persent));
				discountData.setCreatedBy(createorUserId);
				discountDataDAO.persist(discountData);
				// commonService.sendCreateCouponCodeMailforaUser(usersList.get(0),couponcode,adminEmail);
				return "CouponCode Created for userID: " + userId;

			}
		} else {
			return "UserId Not Found";
		}
		// return null;

	}

	@Transactional
	public void createClubCouponeCode(String clubName, String persent, Integer createorUserId, String adminEmail) {
		Users user = new Users();
		user.setClub(clubName);
		List<Users> usersList = usersDAO.findByExample(user);
		List<String> getUserIdofCreatedCouponCode = getUserIdofCreatedCouponCode("usrID");
		for (Users u : usersList) {
			DiscountData discountData = new DiscountData();
			String couponcode = commonService.createCouponCode(u.getUserId(), u.getFirstName(), u.getLastName());
			discountData.setCouponCode(couponcode);
			discountData.setUsers(u);
			discountData.setDiscountPersent(Integer.parseInt(persent));
			discountData.setCreatedBy(createorUserId);

			if (getUserIdofCreatedCouponCode.contains(Integer.toString(u.getUserId()))) {
				System.out.println("in if ");
				DiscountData discountData_exist = new DiscountData();
				discountData_exist.setUsers(u);
				List<DiscountData> DiscountData_existList = discountDataDAO.findByExample(discountData_exist);
				discountData.setDiscountId(DiscountData_existList.get(0).getDiscountId());
				discountDataDAO.attachDirty(discountData);
				// commonService.sendCreateCouponCodeMailforaUser(u,couponcode,adminEmail);
			} else {
				System.out.println("in if ");
				discountDataDAO.persist(discountData);
				// commonService.sendCreateCouponCodeMailforaUser(u,couponcode,adminEmail);
			}

		}

	}

	@Transactional
	public List<String> getUserIdofCreatedCouponCode(String columnName) {

		List<DiscountData> discountDataList = discountDataDAO.findAColumn(columnName);
		List<String> existingCouponCodeList = new ArrayList();
		if (discountDataList.size() > 0) {
			for (DiscountData dd : discountDataList) {
				existingCouponCodeList.add(dd.getUsers().toString());
			}
		}
		System.out.println("existingCouponCodeList=" + existingCouponCodeList);
		return existingCouponCodeList;

	}

	@Transactional
	public List<ClubDTO> getClubData() {

		String sql = "SELECT club, count(user_id) members_count FROM salontest.users where role!='admin' group by club";
		List<ClubDTO> clubList = usersDAO.fetchSql(sql);
		return clubList;
	}

	@Transactional
	public File getImageData(Integer imageId) {

		File fileDetail = new File();
		fileDetail.setFileId(imageId);
		List<File> fileDetailList = fileDetailDAO.findByExample(fileDetail);
		return fileDetailList.get(0);

	}

}
