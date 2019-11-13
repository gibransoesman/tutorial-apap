import React from "react";

export default function List({title}){
    return (
        <>
            <h3 style={styles.heading}>
                {title}
            </h3>
        </>
    );
}

const styles = {
    heading: {
        fontFamily: "courier new"
    }
};