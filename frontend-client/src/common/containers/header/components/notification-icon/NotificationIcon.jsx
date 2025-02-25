import styles from './notificationIcon.module.scss';
import {Link, NavLink} from "react-router-dom";
import {faBell} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

export const NotificationIcon = () => {
  return (
    // <button className={styles.notification}>
    //   <svg className={styles.notification_icon} viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg">
    //     <g id="Layer_2" data-name="Layer 2">
    //       <g id="invisible_box" data-name="invisible box">
    //         <rect width="48" height="48" fill='none' />
    //       </g>
    //       <g id="icons_Q2" data-name="icons Q2">
    //         <path d="M43.4,29.4l-3.2-3.2A4.5,4.5,0,0,1,39,23.3V17C39,8.9,33.6,2,24,2S9,8.7,9,17v7a2.6,2.6,0,0,1-.7,1.7L4.6,29.4A2,2,0,0,0,4,30.8V38a2,2,0,0,0,2,2H17.1a7,7,0,0,0,13.8,0H42a2,2,0,0,0,2-2V30.8A2,2,0,0,0,43.4,29.4Z" />
    //       </g>
    //     </g>
    //   </svg>
    // </button>
      <NavLink to='/notifications' className={styles.notification}>
        {/*<img className={styles.profile_image} src={profileLogotype} alt="" />*/}
        <FontAwesomeIcon className={styles.notification_icon} icon={faBell} />
      </NavLink>
  );
};
