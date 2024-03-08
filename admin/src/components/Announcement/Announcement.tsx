import {AnnouncementTable} from "./AnnouncementTable.tsx";
import {AnnouncementModal} from "./AnnouncementModal.tsx";

import styles from "../utils/styles/EntityModal.module.css"
import { useEffect, useState } from "react";
import {addAnnouncement, deleteAnnouncement, getAllAnnouncements, updateAnnouncement} from "./AnnouncementApi.tsx";
import {AnnouncementProps} from "./AnnouncementProps.tsx";

/**
 * Componenta principală pentru gestionarea anunțurilor.
 * @constructor
 */
export function Announcement() {
    const [open, setOpen] = useState(false);
    const [announcements, setAnnouncements] = useState<AnnouncementProps[]>([]);
    const [announcementToEdit, setAnnouncementToEdit] = useState<null | number>(null);
    const token = localStorage.getItem("loginToken");

    useEffect(() => {
        if(token === "") {
            window.location.href = "/login";
        }
    }, [token]);

    useEffect(() => {
        const getAnnouncements = async () => {
            const res = await getAllAnnouncements(token!);
            setAnnouncements(res);
        }

        getAnnouncements()
    }, []);

    /**
     * Funcție pentru ștergerea unui anunț.
     *  @param announcementId - ID-ul anunțului de șters.
     */
    const handleDeleteAnnouncement = async (announcementId: number) => {
        await deleteAnnouncement(announcementId, token!);
        alert("Announcement deleted successfully!!");
        window.location.href = "/announcements";
    };

    /**
     * * Funcție pentru submiterea unui anunț.
     * @param announcementToSubmit - Anunțul de submitat.
     */
    const handleSubmit = async (announcementToSubmit: AnnouncementProps) => {
        if(announcementToEdit == null) {
            await addAnnouncement(announcementToSubmit, token!);
        }
        else {
            await updateAnnouncement(announcementToSubmit.announcementId, announcementToSubmit, token!);
        }

        alert("Announcement submitted successfully!!");
        window.location.href = "/announcements";
    }

    /**
     * * Funcție pentru editarea unui anunț.
     * @param index - Indexul anunțului de editat.
     */
    const handleEditAnnouncement = (index: number) => {
        setAnnouncementToEdit(index);
        setOpen(true);
    }

    /**
     * Renderea componentei
     */
    return (
        <>
            <button className={styles.submitButton} onClick={() => setOpen(true)}>Add</button>
            <AnnouncementTable announcements={announcements} deleteAnnouncement={handleDeleteAnnouncement} editAnnouncement={handleEditAnnouncement} />
            {open && <AnnouncementModal closeModal={() => {
                setOpen(false);
                setAnnouncementToEdit(null);
            } } onSubmit={handleSubmit} defaultValue={announcements?.[announcementToEdit! - 1]} />}
        </>
    )
}
